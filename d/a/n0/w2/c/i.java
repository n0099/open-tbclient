package d.a.n0.w2.c;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tieba.R;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.m0.r.s.a;
/* loaded from: classes5.dex */
public class i extends d.a.m0.r.s.a {

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f62623a;

    /* renamed from: b  reason: collision with root package name */
    public EditText f62624b;

    /* loaded from: classes5.dex */
    public class a implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f62625e;

        public a(Activity activity) {
            this.f62625e = activity;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            if (!k.isEmpty(i.this.f62624b.getText().toString())) {
                TbSingleton.getInstance().setVisitPreviewServer(true);
                String obj = i.this.f62624b.getText().toString();
                TbSingleton.getInstance().setPubEnvValue(obj);
                l.L(this.f62625e, R.string.change_success);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921508, obj));
            }
            i.this.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.e {
        public b() {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            i.this.dismiss();
        }
    }

    public i(Activity activity) {
        super(activity);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(R.layout.dialog_visit_preview_server, (ViewGroup) null);
        this.f62623a = linearLayout;
        setContentView(linearLayout);
        this.f62624b = (EditText) this.f62623a.findViewById(R.id.et_visit_preview_server_dialog_pub_env_value);
        setPositiveButton(R.string.confirm, new a(activity));
        setNegativeButton(R.string.cancel, new b());
    }
}
