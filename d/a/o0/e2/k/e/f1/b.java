package d.a.o0.e2.k.e.f1;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final View f57131a;

    /* renamed from: b  reason: collision with root package name */
    public final View f57132b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f57133c;

    /* renamed from: d  reason: collision with root package name */
    public PbFragment f57134d;

    /* renamed from: e  reason: collision with root package name */
    public View.OnClickListener f57135e = new a();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = b.this;
            if (view != bVar.f57132b || bVar.f57134d == null || b.this.f57134d.getBaseFragmentActivity() == null) {
                return;
            }
            b.this.f57134d.getBaseFragmentActivity().finish();
        }
    }

    public b(PbFragment pbFragment) {
        this.f57134d = pbFragment;
        this.f57132b = pbFragment.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_back);
        this.f57133c = (TextView) this.f57134d.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_title);
        this.f57131a = this.f57134d.getBaseFragmentActivity().findViewById(R.id.manga_browser_navigation_bar);
        this.f57132b.setOnClickListener(this.f57135e);
    }

    public void b(String str) {
        this.f57133c.setText(str);
    }

    public void c() {
        this.f57131a.setVisibility(0);
    }
}
