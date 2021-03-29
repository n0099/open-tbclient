package d.b.i0.c2.k.e.c1;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final View f52643a;

    /* renamed from: b  reason: collision with root package name */
    public final View f52644b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f52645c;

    /* renamed from: d  reason: collision with root package name */
    public PbFragment f52646d;

    /* renamed from: e  reason: collision with root package name */
    public View.OnClickListener f52647e = new a();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = b.this;
            if (view != bVar.f52644b || bVar.f52646d == null || b.this.f52646d.getBaseFragmentActivity() == null) {
                return;
            }
            b.this.f52646d.getBaseFragmentActivity().finish();
        }
    }

    public b(PbFragment pbFragment) {
        this.f52646d = pbFragment;
        this.f52644b = pbFragment.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_back);
        this.f52645c = (TextView) this.f52646d.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_title);
        this.f52643a = this.f52646d.getBaseFragmentActivity().findViewById(R.id.manga_browser_navigation_bar);
        this.f52644b.setOnClickListener(this.f52647e);
    }

    public void b(String str) {
        this.f52645c.setText(str);
    }

    public void c() {
        this.f52643a.setVisibility(0);
    }
}
