package d.b.i0.c2.k.e.c1;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final View f52642a;

    /* renamed from: b  reason: collision with root package name */
    public final View f52643b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f52644c;

    /* renamed from: d  reason: collision with root package name */
    public PbFragment f52645d;

    /* renamed from: e  reason: collision with root package name */
    public View.OnClickListener f52646e = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = b.this;
            if (view != bVar.f52643b || bVar.f52645d == null || b.this.f52645d.getBaseFragmentActivity() == null) {
                return;
            }
            b.this.f52645d.getBaseFragmentActivity().finish();
        }
    }

    public b(PbFragment pbFragment) {
        this.f52645d = pbFragment;
        this.f52643b = pbFragment.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_back);
        this.f52644c = (TextView) this.f52645d.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_title);
        this.f52642a = this.f52645d.getBaseFragmentActivity().findViewById(R.id.manga_browser_navigation_bar);
        this.f52643b.setOnClickListener(this.f52646e);
    }

    public void b(String str) {
        this.f52644c.setText(str);
    }

    public void c() {
        this.f52642a.setVisibility(0);
    }
}
