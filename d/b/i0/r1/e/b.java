package d.b.i0.r1.e;

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
import d.b.i0.r1.c.b.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<r> f61041e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public MemberTaskCenterActivity f61042f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f61043g;

    /* loaded from: classes3.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f61044a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f61045b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f61046c;

        /* renamed from: d  reason: collision with root package name */
        public View f61047d;

        public a(b bVar) {
        }
    }

    public b(MemberTaskCenterActivity memberTaskCenterActivity) {
        this.f61042f = memberTaskCenterActivity;
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
    public r getItem(int i) {
        List<r> list = this.f61041e;
        if (list == null || list.size() <= i) {
            return null;
        }
        return this.f61041e.get(i);
    }

    public void c(List<r> list) {
        this.f61041e.clear();
        if (list != null) {
            this.f61041e.addAll(list);
        }
    }

    public void d(View.OnClickListener onClickListener) {
        this.f61043g = onClickListener;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<r> list = this.f61041e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view != null && (view.getTag() instanceof a)) {
            aVar = (a) view.getTag();
        } else {
            view = LayoutInflater.from(this.f61042f.getActivity()).inflate(R.layout.member_task_center_item, (ViewGroup) null);
            aVar = new a(this);
            aVar.f61045b = (TextView) view.findViewById(R.id.task_intro);
            aVar.f61044a = (TextView) view.findViewById(R.id.task_name);
            aVar.f61046c = (TextView) view.findViewById(R.id.task_status);
            aVar.f61047d = view.findViewById(R.id.divider_line);
        }
        r item = getItem(i);
        if (item != null) {
            aVar.f61044a.setText(item.f());
            aVar.f61045b.setText(a(String.valueOf(item.a()), item.b()));
            if (item.d()) {
                aVar.f61046c.setText(this.f61042f.getPageContext().getString(R.string.index_task_finish), TextView.BufferType.EDITABLE);
                aVar.f61046c.setTextColor(SkinManager.getColor(R.color.CAM_X0110));
                aVar.f61046c.setBackgroundDrawable(null);
                aVar.f61046c.setOnClickListener(null);
            } else {
                aVar.f61046c.setText(this.f61042f.getPageContext().getString(R.string.default_get_gift), TextView.BufferType.EDITABLE);
                SkinManager.setViewTextColor(aVar.f61046c, R.color.member_center_task_btn_textcolor);
                aVar.f61046c.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.item_blue_btn_selector));
                aVar.f61046c.setTag(item);
                aVar.f61046c.setOnClickListener(this.f61043g);
            }
            SkinManager.setViewTextColor(aVar.f61045b, R.color.CAM_X0109);
            SkinManager.setViewTextColor(aVar.f61044a, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(aVar.f61047d, R.color.CAM_X0204);
        }
        view.setTag(aVar);
        return view;
    }
}
