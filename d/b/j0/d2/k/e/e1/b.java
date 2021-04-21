package d.b.j0.d2.k.e.e1;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final View f54549a;

    /* renamed from: b  reason: collision with root package name */
    public final View f54550b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f54551c;

    /* renamed from: d  reason: collision with root package name */
    public PbFragment f54552d;

    /* renamed from: e  reason: collision with root package name */
    public View.OnClickListener f54553e = new a();

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = b.this;
            if (view != bVar.f54550b || bVar.f54552d == null || b.this.f54552d.getBaseFragmentActivity() == null) {
                return;
            }
            b.this.f54552d.getBaseFragmentActivity().finish();
        }
    }

    public b(PbFragment pbFragment) {
        this.f54552d = pbFragment;
        this.f54550b = pbFragment.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_back);
        this.f54551c = (TextView) this.f54552d.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_title);
        this.f54549a = this.f54552d.getBaseFragmentActivity().findViewById(R.id.manga_browser_navigation_bar);
        this.f54550b.setOnClickListener(this.f54553e);
    }

    public void b(String str) {
        this.f54551c.setText(str);
    }

    public void c() {
        this.f54549a.setVisibility(0);
    }
}
