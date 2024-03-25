package com.example.recyclerbasic;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> {
    Context context;
    ArrayList<ContactModel> arrContacts;
    RecyclerContactAdapter(Context context, ArrayList<ContactModel> arrContacts){
        this.context = context;
        this.arrContacts = arrContacts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_contact, parent , false);
        ViewHolder viewholder = new ViewHolder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       holder.img.setImageResource(arrContacts.get(position).img);
       holder.name.setText(arrContacts.get(position).name);
       holder.number.setText(arrContacts.get(position).number);

       holder.linearLayout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               int adapterPosition = holder.getAdapterPosition();
               Dialog dialog = new Dialog(context);
               dialog.setContentView(R.layout.add_update_layoutfile);

               EditText edtname = dialog.findViewById(R.id.idEdtName);
               EditText edtnumber = dialog.findViewById(R.id.idEdtNumber);
               Button save = dialog.findViewById(R.id.idBtnSave);

               save.setText("UPDATE");

               edtname.setText(arrContacts.get(adapterPosition).name);
               edtnumber.setText(arrContacts.get(adapterPosition).number);

               save.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       String name = "", number = "";
                       if(!edtname.getText().toString().equals("")){
                           name = edtname.getText().toString();
                       }else{
                           Toast.makeText(context, "update credential please empty is not allowed", Toast.LENGTH_SHORT).show();
                       }
                       if(!edtnumber.getText().toString().equals("")){
                           number = edtnumber.getText().toString();
                       }else{
                           Toast.makeText(context, "update credential please empty is not allowed", Toast.LENGTH_SHORT).show();
                       }

                       arrContacts.set(adapterPosition,new ContactModel(arrContacts.get(adapterPosition).img,name,number));
                       notifyItemChanged(adapterPosition);
                       dialog.dismiss();
                   }
               });
                       dialog.show();
           }
       });

       holder.linearLayout.setOnLongClickListener(new View.OnLongClickListener() {
           @Override
           public boolean onLongClick(View view) {
               int adapterPosition = holder.getAdapterPosition();
               AlertDialog.Builder builder = new AlertDialog.Builder(context)
                       .setTitle("Delete Contact")
                       .setMessage("Are you sure want to Delete")
                       .setIcon(R.drawable.ic_delete)
                       .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialogInterface, int i) {
                                arrContacts.remove(adapterPosition);
                                notifyItemChanged(adapterPosition);
                           }
                       })
                       .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialogInterface, int i) {

                           }
                       });

                  builder.show();


               return true;
           }
       });

    }

    @Override
    public int getItemCount() {
        return arrContacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,number ;
        ImageView img;
        LinearLayout linearLayout;
        public ViewHolder(View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.txtName);
            number = itemView.findViewById(R.id.txtNumber);
            img = itemView.findViewById(R.id.idIVImg);
            linearLayout = itemView.findViewById(R.id.idRowMain);

        }
    }
}
