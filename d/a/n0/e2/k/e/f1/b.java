package d.a.n0.e2.k.e.f1;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final View f57006a;

    /* renamed from: b  reason: collision with root package name */
    public final View f57007b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f57008c;

    /* renamed from: d  reason: collision with root package name */
    public PbFragment f57009d;

    /* renamed from: e  reason: collision with root package name */
    public View.OnClickListener f57010e = new a();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = b.this;
            if (view != bVar.f57007b || bVar.f57009d == null || b.this.f57009d.getBaseFragmentActivity() == null) {
                return;
            }
            b.this.f57009d.getBaseFragmentActivity().finish();
        }
    }

    public b(PbFragment pbFragment) {
        this.f57009d = pbFragment;
        this.f57007b = pbFragment.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_back);
        this.f57008c = (TextView) this.f57009d.getBaseFragmentActivity().findViewById(R.id.manga_navigation_bar_title);
        this.f57006a = this.f57009d.getBaseFragmentActivity().findViewById(R.id.manga_browser_navigation_bar);
        this.f57007b.setOnClickListener(this.f57010e);
    }

    public void b(String str) {
        this.f57008c.setText(str);
    }

    public void c() {
        this.f57006a.setVisibility(0);
    }
}
