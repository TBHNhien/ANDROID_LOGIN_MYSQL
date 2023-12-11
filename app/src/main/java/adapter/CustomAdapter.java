package adapter;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ghi_chu.R;

import model.StudentResponse;

//import com.example.nodejsexyoutube.R;
//import com.example.nodejsexyoutube.model.StudentResponse;

import java.util.List;

//public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomView> {
//    private Context context;
//    private List<StudentResponse> customerList;
//
//    public CustomAdapter(Context context, List<StudentResponse> customerList) {
//        this.context = context;
//        this.customerList = customerList;
//    }

//    @NonNull
//    @Override
//    public CustomView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(context).inflate(R.layout.innerlayout, parent, false);
//        return new CustomView(view);
//
//    }

//    @Override
//    public void onBindViewHolder(@NonNull CustomView holder, int position) {
//
//        holder.name.setText("Name :"+customerList.get(position).getName());
//        holder.address.setText("Course :"+customerList.get(position).getCourse());
//
//    }

//    @Override
//    public int getItemCount() {
//        return (customerList == null) ? 0 : customerList.size();
//    }

//    class CustomView extends RecyclerView.ViewHolder {

//        private TextView name, address;


//        public CustomView(@NonNull View itemView) {
//            super(itemView);
//            name = (TextView)itemView.findViewById(R.id.title);
//            address = (TextView)itemView.findViewById(R.id.description);
//
//
//
//        }



//    }
//}
