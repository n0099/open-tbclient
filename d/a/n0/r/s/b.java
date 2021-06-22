package d.a.n0.r.s;

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
    public String f53995a;

    /* renamed from: b  reason: collision with root package name */
    public List<CharSequence> f53996b;

    /* renamed from: c  reason: collision with root package name */
    public c f53997c;

    /* renamed from: d  reason: collision with root package name */
    public final Activity f53998d;

    /* renamed from: e  reason: collision with root package name */
    public final ViewGroup f53999e;

    /* renamed from: f  reason: collision with root package name */
    public final ViewGroup f54000f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f54001g;

    /* renamed from: h  reason: collision with root package name */
    public final View f54002h;

    /* renamed from: i  reason: collision with root package name */
    public int f54003i;
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
        public final /* synthetic */ int f54004e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TextView f54005f;

        public a(int i2, TextView textView) {
            this.f54004e = i2;
            this.f54005f = textView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f53997c.a(b.this, this.f54004e, this.f54005f);
        }
    }

    /* renamed from: d.a.n0.r.s.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C1206b {

        /* renamed from: a  reason: collision with root package name */
        public static final int f54007a = R.style.dialog_ani_b2t;
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
        this.f53998d = activity;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.dialog_bdlist, (ViewGroup) null);
        this.f53999e = viewGroup;
        this.f54001g = (TextView) viewGroup.findViewById(R.id.dialog_title_list);
        this.f54000f = (ViewGroup) this.f53999e.findViewById(R.id.dialog_content);
        this.f54002h = this.f53999e.findViewById(R.id.line_bg);
        this.f54003i = R.layout.dialog_bdlist_item;
    }

    public void b(d.a.c.a.f<?> fVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (fVar instanceof TbPageContext) {
            TbPageContext tbPageContext = (TbPageContext) fVar;
            tbPageContext.getLayoutMode().k(skinType == 1);
            tbPageContext.getLayoutMode().j(this.f53999e);
        }
        this.f53999e.setBackgroundResource(R.drawable.transparent_bg);
    }

    public b c(d.a.c.a.f<?> fVar) {
        if (this.m) {
            return this;
        }
        this.m = true;
        if (!TextUtils.isEmpty(this.f53995a)) {
            this.f54001g.setText(this.f53995a);
            this.f54001g.setVisibility(0);
            this.f54002h.setVisibility(0);
        } else {
            this.f54001g.setVisibility(8);
            this.f54002h.setVisibility(8);
        }
        List<CharSequence> list = this.f53996b;
        if (list != null && list.size() > 0) {
            int size = this.f53996b.size();
            for (int i2 = 0; i2 < size; i2++) {
                d(i2);
            }
        }
        b(fVar);
        return this;
    }

    public final View d(int i2) {
        View inflate = LayoutInflater.from(this.f53998d).inflate(this.f54003i, this.f54000f, false);
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
        CharSequence charSequence = this.f53996b.get(i2);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i2 == this.f53996b.size() - 1) {
            findViewById.setVisibility(8);
            SkinManager.setBackgroundResource(inflate, R.drawable.dialog_single_button_bg_selector);
        } else if (this.f53996b.size() == 1) {
            findViewById.setVisibility(8);
            SkinManager.setBackgroundResource(inflate, R.drawable.dialog_single_button_only_one_bg_selector);
        } else if (i2 == 0 && StringUtils.isNull(this.f53995a)) {
            SkinManager.setBackgroundResource(inflate, R.drawable.dialog_single_button_first_bg_selector);
        } else {
            SkinManager.setBackgroundResource(inflate, R.drawable.dialg_alert_btn_bg);
        }
        if (this.f53997c != null) {
            linearLayout.setOnClickListener(new a(i2, textView));
        }
        this.f54000f.addView(inflate);
        return inflate;
    }

    public void e() {
        AlertDialog alertDialog = this.n;
        if (alertDialog != null) {
            d.a.c.e.m.g.a(alertDialog, this.f53998d);
        }
    }

    public View f(int i2) {
        ViewGroup viewGroup = this.f54000f;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        if (i2 < 0 || i2 > childCount - 1) {
            return null;
        }
        return this.f54000f.getChildAt(i2);
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
            this.f53996b = list;
            if (cVar != null) {
                this.f53997c = cVar;
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
        l(this.f53998d.getResources().getString(i2));
        return this;
    }

    public b l(String str) {
        this.f53995a = str;
        return this;
    }

    public b m() {
        if (this.m) {
            AlertDialog alertDialog = this.n;
            if (alertDialog != null) {
                d.a.c.e.m.g.i(alertDialog, this.f53998d);
                return this;
            }
            AlertDialog create = new AlertDialog.Builder(this.f53998d, R.style.NoBackDimEnableDialog).create();
            this.n = create;
            create.setCanceledOnTouchOutside(true);
            if (d.a.c.e.m.g.i(this.n, this.f53998d)) {
                Window window = this.n.getWindow();
                if (this.j == -1) {
                    this.j = C1206b.f54007a;
                }
                if (this.k == -1) {
                    this.k = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.k);
                window.setContentView(this.f53999e);
                return this;
            }
            return this;
        }
        throw new RuntimeException("Dialog must be created by function create()!");
    }
}
