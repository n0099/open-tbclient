package d.b.i0.d2.k.e.e1;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final View f54128a;

    /* renamed from: b  reason: collision with root package name */
    public final View f54129b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f54130c;

    /* renamed from: d  reason: collision with root package name */
    public PbFragment f54131d;

    /* renamed from: e  reason: collision with root package name */
    public View.OnClickListener f54132e = new a();

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = b.this;
            if (view != bVar.f54129b || bVar.f54131d == null || b.this.f54131d.getBaseFragmentActivity() == null) {
                return;
            }
            b.this.f54131d.getBaseFragmentActivity().finish();
        }
    }

    public b(PbFragment pbFragment) {
        this.f54131d = pbFragment;
        this.f54129b = pbFragment.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_back);
        this.f54130c = (TextView) this.f54131d.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_title);
        this.f54128a = this.f54131d.getBaseFragmentActivity().findViewById(R.id.manga_browser_navigation_bar);
        this.f54129b.setOnClickListener(this.f54132e);
    }

    public void b(String str) {
        this.f54130c.setText(str);
    }

    public void c() {
        this.f54128a.setVisibility(0);
    }
}
