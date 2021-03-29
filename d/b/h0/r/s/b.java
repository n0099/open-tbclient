package d.b.h0.r.s;

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
    public String f50968a;

    /* renamed from: b  reason: collision with root package name */
    public List<CharSequence> f50969b;

    /* renamed from: c  reason: collision with root package name */
    public c f50970c;

    /* renamed from: d  reason: collision with root package name */
    public final Activity f50971d;

    /* renamed from: e  reason: collision with root package name */
    public final ViewGroup f50972e;

    /* renamed from: f  reason: collision with root package name */
    public final ViewGroup f50973f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f50974g;

    /* renamed from: h  reason: collision with root package name */
    public final View f50975h;
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
        public final /* synthetic */ int f50976e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TextView f50977f;

        public a(int i, TextView textView) {
            this.f50976e = i;
            this.f50977f = textView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f50970c.a(b.this, this.f50976e, this.f50977f);
        }
    }

    /* renamed from: d.b.h0.r.s.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C1089b {

        /* renamed from: a  reason: collision with root package name */
        public static final int f50979a = R.style.dialog_ani_b2t;
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
        this.f50971d = activity;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.dialog_bdlist, (ViewGroup) null);
        this.f50972e = viewGroup;
        this.f50974g = (TextView) viewGroup.findViewById(R.id.dialog_title_list);
        this.f50973f = (ViewGroup) this.f50972e.findViewById(R.id.dialog_content);
        this.f50975h = this.f50972e.findViewById(R.id.line_bg);
        this.i = R.layout.dialog_bdlist_item;
    }

    public void b(d.b.b.a.f<?> fVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (fVar instanceof TbPageContext) {
            TbPageContext tbPageContext = (TbPageContext) fVar;
            tbPageContext.getLayoutMode().k(skinType == 1);
            tbPageContext.getLayoutMode().j(this.f50972e);
        }
        this.f50972e.setBackgroundResource(R.drawable.transparent_bg);
    }

    public b c(d.b.b.a.f<?> fVar) {
        if (this.m) {
            return this;
        }
        this.m = true;
        if (!TextUtils.isEmpty(this.f50968a)) {
            this.f50974g.setText(this.f50968a);
            this.f50974g.setVisibility(0);
            this.f50975h.setVisibility(0);
        } else {
            this.f50974g.setVisibility(8);
            this.f50975h.setVisibility(8);
        }
        List<CharSequence> list = this.f50969b;
        if (list != null && list.size() > 0) {
            int size = this.f50969b.size();
            for (int i = 0; i < size; i++) {
                d(i);
            }
        }
        b(fVar);
        return this;
    }

    public final View d(int i) {
        View inflate = LayoutInflater.from(this.f50971d).inflate(this.i, this.f50973f, false);
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
        CharSequence charSequence = this.f50969b.get(i);
        if (charSequence.length() <= 0) {
            charSequence = "";
        }
        textView.setText(charSequence);
        if (i == this.f50969b.size() - 1) {
            findViewById.setVisibility(8);
            SkinManager.setBackgroundResource(inflate, R.drawable.dialog_single_button_bg_selector);
        } else if (this.f50969b.size() == 1) {
            findViewById.setVisibility(8);
            SkinManager.setBackgroundResource(inflate, R.drawable.dialog_single_button_only_one_bg_selector);
        } else if (i == 0 && StringUtils.isNull(this.f50968a)) {
            SkinManager.setBackgroundResource(inflate, R.drawable.dialog_single_button_first_bg_selector);
        } else {
            SkinManager.setBackgroundResource(inflate, R.drawable.dialg_alert_btn_bg);
        }
        if (this.f50970c != null) {
            linearLayout.setOnClickListener(new a(i, textView));
        }
        this.f50973f.addView(inflate);
        return inflate;
    }

    public void e() {
        AlertDialog alertDialog = this.n;
        if (alertDialog != null) {
            d.b.b.e.m.g.a(alertDialog, this.f50971d);
        }
    }

    public View f(int i) {
        ViewGroup viewGroup = this.f50973f;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        if (i < 0 || i > childCount - 1) {
            return null;
        }
        return this.f50973f.getChildAt(i);
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
            this.f50969b = list;
            if (cVar != null) {
                this.f50970c = cVar;
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
        l(this.f50971d.getResources().getString(i));
        return this;
    }

    public b l(String str) {
        this.f50968a = str;
        return this;
    }

    public b m() {
        if (this.m) {
            AlertDialog alertDialog = this.n;
            if (alertDialog != null) {
                d.b.b.e.m.g.i(alertDialog, this.f50971d);
                return this;
            }
            AlertDialog create = new AlertDialog.Builder(this.f50971d, R.style.NoBackDimEnableDialog).create();
            this.n = create;
            create.setCanceledOnTouchOutside(true);
            if (d.b.b.e.m.g.i(this.n, this.f50971d)) {
                Window window = this.n.getWindow();
                if (this.j == -1) {
                    this.j = C1089b.f50979a;
                }
                if (this.k == -1) {
                    this.k = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.k);
                window.setContentView(this.f50972e);
                return this;
            }
            return this;
        }
        throw new RuntimeException("Dialog must be created by function create()!");
    }
}
