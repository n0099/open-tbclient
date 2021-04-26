package d.a.i0.r.s;

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
    public String f49349a;

    /* renamed from: b  reason: collision with root package name */
    public List<CharSequence> f49350b;

    /* renamed from: c  reason: collision with root package name */
    public c f49351c;

    /* renamed from: d  reason: collision with root package name */
    public final Activity f49352d;

    /* renamed from: e  reason: collision with root package name */
    public final ViewGroup f49353e;

    /* renamed from: f  reason: collision with root package name */
    public final ViewGroup f49354f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f49355g;

    /* renamed from: h  reason: collision with root package name */
    public final View f49356h;

    /* renamed from: i  reason: collision with root package name */
    public int f49357i;
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
        public final /* synthetic */ int f49358e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TextView f49359f;

        public a(int i2, TextView textView) {
            this.f49358e = i2;
            this.f49359f = textView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f49351c.a(b.this, this.f49358e, this.f49359f);
        }
    }

    /* renamed from: d.a.i0.r.s.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C1063b {

        /* renamed from: a  reason: collision with root package name */
        public static final int f49361a = R.style.dialog_ani_b2t;
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(b bVar, int i2, View view);
    }

    static {
        HashMap<Integer, Integer[]> hashMap = new HashMap<>(2);
        q = hashMap;
        hashMap.put(0, new Integer[]{Integer.valueOf(R.drawable.dialg_alert_btn_bg), Integer.valueOf(R.drawable.dialog_bdalert_button_textcolor_pressed)});
        q.put(1, new Integer[]{Integer.valueOf(R.drawable.btn_blue_square), Integer.valueOf(R.color.CAM_X0201)});
    }

    public b(Activity activity) {
        this.f49352d = activity;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.dialog_bdlist, (ViewGroup) null);
        this.f49353e = viewGroup;
        this.f49355g = (TextView) viewGroup.findViewById(R.id.dialog_title_list);
        this.f49354f = (ViewGroup) this.f49353e.findViewById(R.id.dialog_content);
        this.f49356h = this.f49353e.findViewById(R.id.line_bg);
        this.f49357i = R.layout.dialog_bdlist_item;
    }

    public void b(d.a.c.a.f<?> fVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (fVar instanceof TbPageContext) {
            TbPageContext tbPageContext = (TbPageContext) fVar;
            tbPageContext.getLayoutMode().k(skinType == 1);
            tbPageContext.getLayoutMode().j(this.f49353e);
        }
        this.f49353e.setBackgroundResource(R.drawable.transparent_bg);
    }

    public b c(d.a.c.a.f<?> fVar) {
        if (this.m) {
            return this;
        }
        this.m = true;
        if (!TextUtils.isEmpty(this.f49349a)) {
            this.f49355g.setText(this.f49349a);
            this.f49355g.setVisibility(0);
            this.f49356h.setVisibility(0);
        } else {
            this.f49355g.setVisibility(8);
            this.f49356h.setVisibility(8);
        }
        List<CharSequence> list = this.f49350b;
        if (list != null && list.size() > 0) {
            int size = this.f49350b.size();
            for (int i2 = 0; i2 < size; i2++) {
                d(i2);
            }
        }
        b(fVar);
        return this;
    }

    public final View d(int i2) {
        View inflate = LayoutInflater.from(this.f49352d).inflate(this.f49357i, this.f49354f, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        TextView textView = (TextView) inflate.findViewById(R.id.dialog_item_btn);
        LinearLayout.LayoutParams layoutParams = this.p;
        if (layoutParams != null) {
            textView.setLayoutParams(layoutParams);
        }
        int i3 = this.l;
        if (i3 != -1) {
            textView.setTextSize(0, i3);
        }
        if (this.o != -1) {
            textView.setPadding(0, 0, 0, 0);
            textView.setGravity(this.o);
        }
        View findViewById = inflate.findViewById(R.id.line);
        CharSequence charSequence = this.f49350b.get(i2);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i2 == this.f49350b.size() - 1) {
            findViewById.setVisibility(8);
            SkinManager.setBackgroundResource(inflate, R.drawable.dialog_single_button_bg_selector);
        } else if (this.f49350b.size() == 1) {
            findViewById.setVisibility(8);
            SkinManager.setBackgroundResource(inflate, R.drawable.dialog_single_button_only_one_bg_selector);
        } else if (i2 == 0 && StringUtils.isNull(this.f49349a)) {
            SkinManager.setBackgroundResource(inflate, R.drawable.dialog_single_button_first_bg_selector);
        } else {
            SkinManager.setBackgroundResource(inflate, R.drawable.dialg_alert_btn_bg);
        }
        if (this.f49351c != null) {
            linearLayout.setOnClickListener(new a(i2, textView));
        }
        this.f49354f.addView(inflate);
        return inflate;
    }

    public void e() {
        AlertDialog alertDialog = this.n;
        if (alertDialog != null) {
            d.a.c.e.m.g.a(alertDialog, this.f49352d);
        }
    }

    public View f(int i2) {
        ViewGroup viewGroup = this.f49354f;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        if (i2 < 0 || i2 > childCount - 1) {
            return null;
        }
        return this.f49354f.getChildAt(i2);
    }

    public b g(int i2) {
        this.j = i2;
        return this;
    }

    public b h(int i2) {
        this.k = i2;
        return this;
    }

    public b i(List<CharSequence> list, c cVar) {
        if (list != null && list.size() > 0) {
            this.f49350b = list;
            if (cVar != null) {
                this.f49351c = cVar;
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

    public b k(int i2) {
        l(this.f49352d.getResources().getString(i2));
        return this;
    }

    public b l(String str) {
        this.f49349a = str;
        return this;
    }

    public b m() {
        if (this.m) {
            AlertDialog alertDialog = this.n;
            if (alertDialog != null) {
                d.a.c.e.m.g.i(alertDialog, this.f49352d);
                return this;
            }
            AlertDialog create = new AlertDialog.Builder(this.f49352d, R.style.NoBackDimEnableDialog).create();
            this.n = create;
            create.setCanceledOnTouchOutside(true);
            if (d.a.c.e.m.g.i(this.n, this.f49352d)) {
                Window window = this.n.getWindow();
                if (this.j == -1) {
                    this.j = C1063b.f49361a;
                }
                if (this.k == -1) {
                    this.k = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.k);
                window.setContentView(this.f49353e);
                return this;
            }
            return this;
        }
        throw new RuntimeException("Dialog must be created by function create()!");
    }
}
