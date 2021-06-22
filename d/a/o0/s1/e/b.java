package d.a.o0.s1.e;

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
import d.a.o0.s1.c.b.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<r> f64292e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public MemberTaskCenterActivity f64293f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f64294g;

    /* loaded from: classes4.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f64295a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f64296b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f64297c;

        /* renamed from: d  reason: collision with root package name */
        public View f64298d;

        public a(b bVar) {
        }
    }

    public b(MemberTaskCenterActivity memberTaskCenterActivity) {
        this.f64293f = memberTaskCenterActivity;
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
        List<r> list = this.f64292e;
        if (list == null || list.size() <= i2) {
            return null;
        }
        return this.f64292e.get(i2);
    }

    public void c(List<r> list) {
        this.f64292e.clear();
        if (list != null) {
            this.f64292e.addAll(list);
        }
    }

    public void d(View.OnClickListener onClickListener) {
        this.f64294g = onClickListener;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<r> list = this.f64292e;
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
            view = LayoutInflater.from(this.f64293f.getActivity()).inflate(R.layout.member_task_center_item, (ViewGroup) null);
            aVar = new a(this);
            aVar.f64296b = (TextView) view.findViewById(R.id.task_intro);
            aVar.f64295a = (TextView) view.findViewById(R.id.task_name);
            aVar.f64297c = (TextView) view.findViewById(R.id.task_status);
            aVar.f64298d = view.findViewById(R.id.divider_line);
        }
        r item = getItem(i2);
        if (item != null) {
            aVar.f64295a.setText(item.f());
            aVar.f64296b.setText(a(String.valueOf(item.a()), item.b()));
            if (item.d()) {
                aVar.f64297c.setText(this.f64293f.getPageContext().getString(R.string.index_task_finish), TextView.BufferType.EDITABLE);
                aVar.f64297c.setTextColor(SkinManager.getColor(R.color.CAM_X0110));
                aVar.f64297c.setBackgroundDrawable(null);
                aVar.f64297c.setOnClickListener(null);
            } else {
                aVar.f64297c.setText(this.f64293f.getPageContext().getString(R.string.default_get_gift), TextView.BufferType.EDITABLE);
                SkinManager.setViewTextColor(aVar.f64297c, R.color.member_center_task_btn_textcolor);
                aVar.f64297c.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.item_blue_btn_selector));
                aVar.f64297c.setTag(item);
                aVar.f64297c.setOnClickListener(this.f64294g);
            }
            SkinManager.setViewTextColor(aVar.f64296b, R.color.CAM_X0109);
            SkinManager.setViewTextColor(aVar.f64295a, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(aVar.f64298d, R.color.CAM_X0204);
        }
        view.setTag(aVar);
        return view;
    }
}
