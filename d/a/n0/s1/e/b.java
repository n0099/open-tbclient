package d.a.n0.s1.e;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterActivity;
import d.a.n0.s1.c.b.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<r> f64167e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public MemberTaskCenterActivity f64168f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f64169g;

    /* loaded from: classes3.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f64170a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f64171b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f64172c;

        /* renamed from: d  reason: collision with root package name */
        public View f64173d;

        public a(b bVar) {
        }
    }

    public b(MemberTaskCenterActivity memberTaskCenterActivity) {
        this.f64168f = memberTaskCenterActivity;
    }

    public final SpannableString a(String str, String str2) {
        SpannableString spannableString = new SpannableString(str + str2);
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301)), 0, str.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109)), str.length(), spannableString.length(), 33);
        return spannableString;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: b */
    public r getItem(int i2) {
        List<r> list = this.f64167e;
        if (list == null || list.size() <= i2) {
            return null;
        }
        return this.f64167e.get(i2);
    }

    public void c(List<r> list) {
        this.f64167e.clear();
        if (list != null) {
            this.f64167e.addAll(list);
        }
    }

    public void d(View.OnClickListener onClickListener) {
        this.f64169g = onClickListener;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<r> list = this.f64167e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        if (view != null && (view.getTag() instanceof a)) {
            aVar = (a) view.getTag();
        } else {
            view = LayoutInflater.from(this.f64168f.getActivity()).inflate(R.layout.member_task_center_item, (ViewGroup) null);
            aVar = new a(this);
            aVar.f64171b = (TextView) view.findViewById(R.id.task_intro);
            aVar.f64170a = (TextView) view.findViewById(R.id.task_name);
            aVar.f64172c = (TextView) view.findViewById(R.id.task_status);
            aVar.f64173d = view.findViewById(R.id.divider_line);
        }
        r item = getItem(i2);
        if (item != null) {
            aVar.f64170a.setText(item.f());
            aVar.f64171b.setText(a(String.valueOf(item.a()), item.b()));
            if (item.d()) {
                aVar.f64172c.setText(this.f64168f.getPageContext().getString(R.string.index_task_finish), TextView.BufferType.EDITABLE);
                aVar.f64172c.setTextColor(SkinManager.getColor(R.color.CAM_X0110));
                aVar.f64172c.setBackgroundDrawable(null);
                aVar.f64172c.setOnClickListener(null);
            } else {
                aVar.f64172c.setText(this.f64168f.getPageContext().getString(R.string.default_get_gift), TextView.BufferType.EDITABLE);
                SkinManager.setViewTextColor(aVar.f64172c, R.color.member_center_task_btn_textcolor);
                aVar.f64172c.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.item_blue_btn_selector));
                aVar.f64172c.setTag(item);
                aVar.f64172c.setOnClickListener(this.f64169g);
            }
            SkinManager.setViewTextColor(aVar.f64171b, R.color.CAM_X0109);
            SkinManager.setViewTextColor(aVar.f64170a, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(aVar.f64173d, R.color.CAM_X0204);
        }
        view.setTag(aVar);
        return view;
    }
}
