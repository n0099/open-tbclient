package d.a.n0.e2.k.e.f1;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final View f53317a;

    /* renamed from: b  reason: collision with root package name */
    public final View f53318b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f53319c;

    /* renamed from: d  reason: collision with root package name */
    public PbFragment f53320d;

    /* renamed from: e  reason: collision with root package name */
    public View.OnClickListener f53321e = new a();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = b.this;
            if (view != bVar.f53318b || bVar.f53320d == null || b.this.f53320d.getBaseFragmentActivity() == null) {
                return;
            }
            b.this.f53320d.getBaseFragmentActivity().finish();
        }
    }

    public b(PbFragment pbFragment) {
        this.f53320d = pbFragment;
        this.f53318b = pbFragment.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_back);
        this.f53319c = (TextView) this.f53320d.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_title);
        this.f53317a = this.f53320d.getBaseFragmentActivity().findViewById(R.id.manga_browser_navigation_bar);
        this.f53318b.setOnClickListener(this.f53321e);
    }

    public void b(String str) {
        this.f53319c.setText(str);
    }

    public void c() {
        this.f53317a.setVisibility(0);
    }
}
