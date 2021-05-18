package d.a.k0.d2.k.e.e1;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final View f53052a;

    /* renamed from: b  reason: collision with root package name */
    public final View f53053b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f53054c;

    /* renamed from: d  reason: collision with root package name */
    public PbFragment f53055d;

    /* renamed from: e  reason: collision with root package name */
    public View.OnClickListener f53056e = new a();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = b.this;
            if (view != bVar.f53053b || bVar.f53055d == null || b.this.f53055d.getBaseFragmentActivity() == null) {
                return;
            }
            b.this.f53055d.getBaseFragmentActivity().finish();
        }
    }

    public b(PbFragment pbFragment) {
        this.f53055d = pbFragment;
        this.f53053b = pbFragment.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_back);
        this.f53054c = (TextView) this.f53055d.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_title);
        this.f53052a = this.f53055d.getBaseFragmentActivity().findViewById(R.id.manga_browser_navigation_bar);
        this.f53053b.setOnClickListener(this.f53056e);
    }

    public void b(String str) {
        this.f53054c.setText(str);
    }

    public void c() {
        this.f53052a.setVisibility(0);
    }
}
