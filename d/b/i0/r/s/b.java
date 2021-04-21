package d.b.i0.r.s;

import android.app.Activity;
import android.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    public static final HashMap<Integer, Integer[]> q;

    /* renamed from: a  reason: collision with root package name */
    public String f51711a;

    /* renamed from: b  reason: collision with root package name */
    public List<CharSequence> f51712b;

    /* renamed from: c  reason: collision with root package name */
    public c f51713c;

    /* renamed from: d  reason: collision with root package name */
    public final Activity f51714d;

    /* renamed from: e  reason: collision with root package name */
    public final ViewGroup f51715e;

    /* renamed from: f  reason: collision with root package name */
    public final ViewGroup f51716f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f51717g;

    /* renamed from: h  reason: collision with root package name */
    public final View f51718h;
    public int i;
    public AlertDialog n;
    public LinearLayout.LayoutParams p;
    public int j = -1;
    public int k = -1;
    public int l = -1;
    public boolean m = false;
    public int o = -1;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f51719e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TextView f51720f;

        public a(int i, TextView textView) {
            this.f51719e = i;
            this.f51720f = textView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f51713c.a(b.this, this.f51719e, this.f51720f);
        }
    }

    /* renamed from: d.b.i0.r.s.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C1124b {

        /* renamed from: a  reason: collision with root package name */
        public static final int f51722a = R.style.dialog_ani_b2t;
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(b bVar, int i, View view);
    }

    static {
        HashMap<Integer, Integer[]> hashMap = new HashMap<>(2);
        q = hashMap;
        hashMap.put(0, new Integer[]{Integer.valueOf(R.drawable.dialg_alert_btn_bg), Integer.valueOf(R.drawable.dialog_bdalert_button_textcolor_pressed)});
        q.put(1, new Integer[]{Integer.valueOf(R.drawable.btn_blue_square), Integer.valueOf(R.color.CAM_X0201)});
    }

    public b(Activity activity) {
        this.f51714d = activity;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.dialog_bdlist, (ViewGroup) null);
        this.f51715e = viewGroup;
        this.f51717g = (TextView) viewGroup.findViewById(R.id.dialog_title_list);
        this.f51716f = (ViewGroup) this.f51715e.findViewById(R.id.dialog_content);
        this.f51718h = this.f51715e.findViewById(R.id.line_bg);
        this.i = R.layout.dialog_bdlist_item;
    }

    public void b(d.b.c.a.f<?> fVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (fVar instanceof TbPageContext) {
            TbPageContext tbPageContext = (TbPageContext) fVar;
            tbPageContext.getLayoutMode().k(skinType == 1);
            tbPageContext.getLayoutMode().j(this.f51715e);
        }
        this.f51715e.setBackgroundResource(R.drawable.transparent_bg);
    }

    public b c(d.b.c.a.f<?> fVar) {
        if (this.m) {
            return this;
        }
        this.m = true;
        if (!TextUtils.isEmpty(this.f51711a)) {
            this.f51717g.setText(this.f51711a);
            this.f51717g.setVisibility(0);
            this.f51718h.setVisibility(0);
        } else {
            this.f51717g.setVisibility(8);
            this.f51718h.setVisibility(8);
        }
        List<CharSequence> list = this.f51712b;
        if (list != null && list.size() > 0) {
            int size = this.f51712b.size();
            for (int i = 0; i < size; i++) {
                d(i);
            }
        }
        b(fVar);
        return this;
    }

    public final View d(int i) {
        View inflate = LayoutInflater.from(this.f51714d).inflate(this.i, this.f51716f, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        TextView textView = (TextView) inflate.findViewById(R.id.dialog_item_btn);
        LinearLayout.LayoutParams layoutParams = this.p;
        if (layoutParams != null) {
            textView.setLayoutParams(layoutParams);
        }
        int i2 = this.l;
        if (i2 != -1) {
            textView.setTextSize(0, i2);
        }
        if (this.o != -1) {
            textView.setPadding(0, 0, 0, 0);
            textView.setGravity(this.o);
        }
        View findViewById = inflate.findViewById(R.id.line);
        CharSequence charSequence = this.f51712b.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.f51712b.size() - 1) {
            findViewById.setVisibility(8);
            SkinManager.setBackgroundResource(inflate, R.drawable.dialog_single_button_bg_selector);
        } else if (this.f51712b.size() == 1) {
            findViewById.setVisibility(8);
            SkinManager.setBackgroundResource(inflate, R.drawable.dialog_single_button_only_one_bg_selector);
        } else if (i == 0 && StringUtils.isNull(this.f51711a)) {
            SkinManager.setBackgroundResource(inflate, R.drawable.dialog_single_button_first_bg_selector);
        } else {
            SkinManager.setBackgroundResource(inflate, R.drawable.dialg_alert_btn_bg);
        }
        if (this.f51713c != null) {
            linearLayout.setOnClickListener(new a(i, textView));
        }
        this.f51716f.addView(inflate);
        return inflate;
    }

    public void e() {
        AlertDialog alertDialog = this.n;
        if (alertDialog != null) {
            d.b.c.e.m.g.a(alertDialog, this.f51714d);
        }
    }

    public View f(int i) {
        ViewGroup viewGroup = this.f51716f;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        if (i < 0 || i > childCount - 1) {
            return null;
        }
        return this.f51716f.getChildAt(i);
    }

    public b g(int i) {
        this.j = i;
        return this;
    }

    public b h(int i) {
        this.k = i;
        return this;
    }

    public b i(List<CharSequence> list, c cVar) {
        if (list != null && list.size() > 0) {
            this.f51712b = list;
            if (cVar != null) {
                this.f51713c = cVar;
            }
        }
        return this;
    }

    public b j(CharSequence[] charSequenceArr, c cVar) {
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            i(Arrays.asList(charSequenceArr), cVar);
        }
        return this;
    }

    public b k(int i) {
        l(this.f51714d.getResources().getString(i));
        return this;
    }

    public b l(String str) {
        this.f51711a = str;
        return this;
    }

    public b m() {
        if (this.m) {
            AlertDialog alertDialog = this.n;
            if (alertDialog != null) {
                d.b.c.e.m.g.i(alertDialog, this.f51714d);
                return this;
            }
            AlertDialog create = new AlertDialog.Builder(this.f51714d, R.style.NoBackDimEnableDialog).create();
            this.n = create;
            create.setCanceledOnTouchOutside(true);
            if (d.b.c.e.m.g.i(this.n, this.f51714d)) {
                Window window = this.n.getWindow();
                if (this.j == -1) {
                    this.j = C1124b.f51722a;
                }
                if (this.k == -1) {
                    this.k = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.k);
                window.setContentView(this.f51715e);
                return this;
            }
            return this;
        }
        throw new RuntimeException("Dialog must be created by function create()!");
    }
}
