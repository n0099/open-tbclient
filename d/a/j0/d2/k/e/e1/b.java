package d.a.j0.d2.k.e.e1;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final View f52353a;

    /* renamed from: b  reason: collision with root package name */
    public final View f52354b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f52355c;

    /* renamed from: d  reason: collision with root package name */
    public PbFragment f52356d;

    /* renamed from: e  reason: collision with root package name */
    public View.OnClickListener f52357e = new a();

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = b.this;
            if (view != bVar.f52354b || bVar.f52356d == null || b.this.f52356d.getBaseFragmentActivity() == null) {
                return;
            }
            b.this.f52356d.getBaseFragmentActivity().finish();
        }
    }

    public b(PbFragment pbFragment) {
        this.f52356d = pbFragment;
        this.f52354b = pbFragment.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_back);
        this.f52355c = (TextView) this.f52356d.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_title);
        this.f52353a = this.f52356d.getBaseFragmentActivity().findViewById(R.id.manga_browser_navigation_bar);
        this.f52354b.setOnClickListener(this.f52357e);
    }

    public void b(String str) {
        this.f52355c.setText(str);
    }

    public void c() {
        this.f52353a.setVisibility(0);
    }
}
