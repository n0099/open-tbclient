package d.a.n0.s3;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.StringRes;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.R;
import d.a.c.a.f;
import d.a.c.e.l.d;
import d.a.c.e.p.k;
import d.a.m0.r.s.a;
/* loaded from: classes5.dex */
public class a extends d.a.m0.r.s.a implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f64438e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f64439f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f64440g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f64441h;

    /* renamed from: i  reason: collision with root package name */
    public TbCheckBox f64442i;
    public TextView j;
    public Button k;
    public Button l;
    public ImageView m;
    public String n;
    public String o;
    public String p;
    public a.e q;
    public String r;
    public a.e s;
    public String t;
    public CompoundButton.OnCheckedChangeListener u;
    public boolean v;
    public TbCheckBox.b w;
    public final d.a.c.e.l.c<d.a.c.k.d.a> x;

    /* renamed from: d.a.n0.s3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1659a implements TbCheckBox.b {
        public C1659a() {
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.b
        public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
            if (a.this.u != null) {
                a.this.u.onCheckedChanged(null, z);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends d.a.c.e.l.c<d.a.c.k.d.a> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
            super.onLoaded((b) aVar, str, i2);
            if (aVar == null || !aVar.w()) {
                a.this.f64439f.setImageResource(R.drawable.frs_luhan_moren_background);
                return;
            }
            a.this.f64439f.setBackgroundResource(0);
            a.this.f64439f.setImageDrawable(null);
            aVar.h(a.this.f64439f);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements TbCheckBox.c {

        /* renamed from: e  reason: collision with root package name */
        public boolean f64445e = false;

        public c(a aVar) {
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.c
        public boolean isChecked() {
            return this.f64445e;
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.c
        public void setChecked(boolean z) {
            this.f64445e = z;
        }
    }

    public a(Activity activity) {
        super(activity);
        this.v = false;
        this.w = new C1659a();
        this.x = new b();
        c();
        setContentViewSize(1);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    public final void c() {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.easter_egg_dialog, (ViewGroup) null);
        this.f64438e = viewGroup;
        this.f64439f = (ImageView) viewGroup.findViewById(R.id.dialog_bg);
        this.f64440g = (TextView) this.f64438e.findViewById(R.id.message);
        Button button = (Button) this.f64438e.findViewById(R.id.negative_btn);
        this.l = button;
        button.setOnClickListener(this);
        Button button2 = (Button) this.f64438e.findViewById(R.id.positive_btn);
        this.k = button2;
        button2.setOnClickListener(this);
        ImageView imageView = (ImageView) this.f64438e.findViewById(R.id.close);
        this.m = imageView;
        imageView.setOnClickListener(this);
        this.f64441h = (ViewGroup) this.f64438e.findViewById(R.id.checkbox_container);
        this.j = (TextView) this.f64438e.findViewById(R.id.checkbox_text);
        TbCheckBox tbCheckBox = (TbCheckBox) this.f64438e.findViewById(R.id.checkbox);
        this.f64442i = tbCheckBox;
        tbCheckBox.setBackgroundDrawableId(R.drawable.icon_frs_luhan_selct, R.drawable.icon_frs_luhan_selctguand);
        this.f64442i.setStatedChangedListener(this.w);
        this.f64442i.setTagData(new c(this));
        this.f64441h.setClickable(true);
        this.f64441h.setOnClickListener(this);
        setContentView(this.f64438e);
    }

    @Override // d.a.m0.r.s.a
    public d.a.m0.r.s.a create(f<?> fVar) {
        if (this.v) {
            return this;
        }
        this.v = true;
        super.create(fVar);
        if (!k.isEmpty(this.o)) {
            this.f64440g.setText(this.o);
        }
        if (!k.isEmpty(this.t)) {
            this.j.setText(this.t);
        } else {
            this.f64441h.setVisibility(4);
        }
        if (!k.isEmpty(this.r)) {
            this.l.setText(this.r);
        }
        if (!k.isEmpty(this.p)) {
            this.k.setText(this.p);
        }
        if (!TextUtils.isEmpty(this.n)) {
            d.h().m(this.n, 10, this.x, fVar.getUniqueId());
        } else {
            this.f64439f.setImageResource(R.drawable.frs_luhan_moren_background);
        }
        getRealView().setBackgroundDrawable(null);
        return this;
    }

    public a d(@StringRes int i2, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        Activity activity = this.mActivity;
        if (activity != null) {
            this.t = activity.getResources().getString(i2);
            this.u = onCheckedChangeListener;
        }
        return this;
    }

    public a e(String str) {
        this.n = str;
        return this;
    }

    public a f(String str) {
        this.o = str;
        return this;
    }

    public a g(@StringRes int i2, a.e eVar) {
        Activity activity = this.mActivity;
        if (activity != null) {
            this.r = activity.getResources().getString(i2);
            this.s = eVar;
        }
        return this;
    }

    public a h(int i2, a.e eVar) {
        Activity activity = this.mActivity;
        if (activity != null) {
            this.p = activity.getResources().getString(i2);
            this.q = eVar;
        }
        return this;
    }

    public a i(String str, a.e eVar) {
        this.p = str;
        this.q = eVar;
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        if (id == R.id.positive_btn) {
            a.e eVar = this.q;
            if (eVar != null) {
                eVar.onClick(this);
            }
        } else if (id == R.id.negative_btn) {
            a.e eVar2 = this.s;
            if (eVar2 != null) {
                eVar2.onClick(this);
            }
        } else if (id == R.id.close) {
            dismiss();
        } else if (id == R.id.checkbox_container) {
            TbCheckBox tbCheckBox = this.f64442i;
            tbCheckBox.setChecked(!tbCheckBox.d());
        }
    }

    @Override // d.a.m0.r.s.a
    public /* bridge */ /* synthetic */ d.a.m0.r.s.a setMessage(String str) {
        f(str);
        return this;
    }

    @Override // d.a.m0.r.s.a
    public /* bridge */ /* synthetic */ d.a.m0.r.s.a setNegativeButton(@StringRes int i2, a.e eVar) {
        g(i2, eVar);
        return this;
    }

    @Override // d.a.m0.r.s.a
    public /* bridge */ /* synthetic */ d.a.m0.r.s.a setPositiveButton(int i2, a.e eVar) {
        h(i2, eVar);
        return this;
    }

    @Override // d.a.m0.r.s.a
    public d.a.m0.r.s.a setNegativeButton(String str, a.e eVar) {
        this.r = str;
        this.s = eVar;
        return this;
    }

    @Override // d.a.m0.r.s.a
    public /* bridge */ /* synthetic */ d.a.m0.r.s.a setPositiveButton(String str, a.e eVar) {
        i(str, eVar);
        return this;
    }
}
