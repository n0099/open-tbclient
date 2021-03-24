package d.b.i0.v2.g;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.svg.AbsSvgType;
import com.baidu.tbadk.core.util.svg.SvgMaskType;
import com.baidu.tbadk.core.util.svg.SvgPureType;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import d.b.b.e.p.j;
import d.b.b.e.p.k;
import d.b.b.e.p.l;
import d.b.h0.s.c.d0;
import d.b.h0.s.g.g;
import d.b.i0.c3.z;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a implements View.OnClickListener {
    public static final int r;
    public static final int s;
    public static final int t;
    public static final int u;
    public static final int v;
    public static final int w;

    /* renamed from: e  reason: collision with root package name */
    public final Context f62067e;

    /* renamed from: f  reason: collision with root package name */
    public final View f62068f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f62069g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f62070h;
    public ShareGridLayout i;
    public View.OnClickListener k;
    public DialogInterface.OnDismissListener l;
    public AlertDialog m;
    public SparseArray<String> p;
    public SparseArray<d0> q;
    public final SparseArray<ShareItem> n = new SparseArray<>(8);
    public boolean o = false;
    public final List<View> j = new ArrayList();

    /* renamed from: d.b.i0.v2.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1642a implements CustomMessageTask.CustomRunnable<Object> {
        public C1642a() {
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            if (a.this.m == null || !a.this.m.isShowing()) {
                return null;
            }
            a.this.f();
            return null;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements DialogInterface.OnDismissListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (a.this.l != null) {
                a.this.l.onDismiss(dialogInterface);
            }
            MessageManager.getInstance().unRegisterTask(2001277);
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public View.OnClickListener f62073e;

        public c(View.OnClickListener onClickListener) {
            this.f62073e = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f();
            View.OnClickListener onClickListener = this.f62073e;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    static {
        double k = l.k(TbadkCoreApplication.getInst()) - (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
        Double.isNaN(k);
        r = (int) (k * 0.2d);
        s = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds234);
        t = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds104);
        u = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds36);
        v = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds26);
        w = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    }

    public a(Context context, boolean z, int i) {
        this.f62067e = context;
        View inflate = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.ala_share_dialog_content, (ViewGroup) null);
        this.f62068f = inflate;
        this.f62070h = (TextView) inflate.findViewById(R.id.share_dialog_title);
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.f62070h.setText(sharePanelText);
        }
        ShareGridLayout shareGridLayout = (ShareGridLayout) this.f62068f.findViewById(R.id.share_grid_layout);
        this.i = shareGridLayout;
        ViewGroup.LayoutParams layoutParams = shareGridLayout.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i2 = ShareGridLayout.j;
            marginLayoutParams.leftMargin = i2;
            marginLayoutParams.rightMargin = i2;
            this.i.setLayoutParams(marginLayoutParams);
        }
        this.i.setItemParams(r, s);
        TextView textView = (TextView) this.f62068f.findViewById(R.id.btnShareCancel);
        this.f62069g = textView;
        textView.setOnClickListener(this);
        if (!p(i)) {
            n(new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4);
        }
        if (!q(i)) {
            n(new SvgMaskType(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3);
        }
        if (!o(i)) {
            n(new SvgMaskType(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9);
        }
        if (!r(i)) {
            n(new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7);
        }
        if (g.g()) {
            return;
        }
        this.i.setVisibility(8);
    }

    public final void A(int i, String str) {
        TiebaStatic.eventStat(this.f62067e, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    public final void B(ShareItem shareItem, int i) {
        if (shareItem == null || shareItem.q == null) {
            return;
        }
        if (shareItem.f13712b) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", shareItem.q).param("obj_type", i));
        } else if (!shareItem.f13713c && !shareItem.f13716f) {
            if (shareItem.f13714d) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).param("tid", shareItem.q).param("obj_type", i));
            } else if (shareItem.f13711a) {
                A(i, shareItem.B);
            } else if (shareItem.f13715e) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", 7).param("obj_type", i).param("fid", shareItem.q));
            } else if (shareItem.f13717g) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i);
                if (!k.isEmpty(shareItem.t) && shareItem.t.contains("worldcup")) {
                    param.param("obj_param1", 9);
                }
                TiebaStatic.log(param);
            }
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("tid", shareItem.q).param("obj_type", i).param("obj_source", shareItem.D).param("obj_param1", shareItem.E).param("fid", shareItem.I));
        }
    }

    public void c(View view, int i, View.OnClickListener onClickListener) {
        if (i > this.j.size() || i < 0) {
            return;
        }
        this.j.add(i, view);
        if (onClickListener != null) {
            view.setOnClickListener(new c(onClickListener));
        }
    }

    public void d() {
        for (int i = 0; i < this.j.size(); i++) {
            this.i.addView(this.j.get(i), new ViewGroup.LayoutParams(r, s));
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void e() {
    }

    public void f() {
        AlertDialog alertDialog = this.m;
        if (alertDialog != null) {
            this.o = false;
            Context context = this.f62067e;
            if (context instanceof Activity) {
                d.b.b.e.m.g.a(alertDialog, (Activity) context);
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
            }
        }
    }

    public int h() {
        List<View> list = this.j;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final String i(ShareItem shareItem) {
        String str = "【" + shareItem.r + "】 " + shareItem.s;
        shareItem.s = str;
        return str;
    }

    public final Location j() {
        if (PermissionUtil.checkLocationForGoogle(this.f62067e)) {
            LocationManager locationManager = (LocationManager) this.f62067e.getSystemService("location");
            Criteria criteria = new Criteria();
            criteria.setAccuracy(1);
            criteria.setAltitudeRequired(false);
            criteria.setBearingRequired(false);
            criteria.setCostAllowed(true);
            criteria.setPowerRequirement(1);
            try {
                return locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, false));
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public final ShareItem k(int i) {
        ShareItem shareItem = this.n.get(i);
        return shareItem == null ? this.n.get(1) : shareItem;
    }

    public void l(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.l = onDismissListener;
        }
    }

    public LinearLayout m(int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(this.f62067e);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.f62067e);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0213).into(imageView);
        int i3 = t;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
        layoutParams.topMargin = u;
        layoutParams.bottomMargin = v;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.f62067e);
        textView.setTextSize(0, w);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        imageView.setImageResource(i2);
        textView.setTextColor(this.f62067e.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
        return linearLayout;
    }

    public final void n(AbsSvgType absSvgType, int i, int i2) {
        if (absSvgType == null) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(this.f62067e);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.f62067e);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (absSvgType instanceof SvgPureType) {
            TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0213).into(imageView);
        }
        int i3 = t;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
        layoutParams.topMargin = u;
        layoutParams.bottomMargin = v;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.f62067e);
        textView.setTextSize(0, w);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        imageView.setImageDrawable(absSvgType.getDrawable());
        textView.setTextColor(this.f62067e.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
        linearLayout.setOnClickListener(this);
        this.j.add(linearLayout);
    }

    public final boolean o(int i) {
        return (i & 8) > 0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        int intValue = view.getTag() != null ? ((Integer) view.getTag()).intValue() : -1;
        f();
        if (this.n.size() == 0) {
            return;
        }
        if (view.getId() == R.id.btnShareCancel || !this.o) {
            this.o = true;
            g gVar = new g(this.f62067e, null);
            ShareItem k = k(1);
            if (id == R.id.btnShareCancel) {
                x("share_cancel", new Object[0]);
                f();
            } else if (intValue == 4) {
                if (!j.z()) {
                    l.K(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    return;
                }
                x("share_to_weixin", new Object[0]);
                y(3);
                ShareItem k2 = k(3);
                B(k2, 4);
                if (k2 != null) {
                    gVar.m(k2);
                }
            } else if (intValue == 3) {
                if (!j.z()) {
                    l.K(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    return;
                }
                x("share_to_pyq", new Object[0]);
                y(2);
                ShareItem k3 = k(2);
                B(k3, 3);
                if (k3 != null) {
                    if (k3.f13712b) {
                        k3.s = "【" + k3.r + "】 " + k3.s;
                    }
                    gVar.n(k3);
                }
            } else if (intValue == 5) {
                if (!j.z()) {
                    l.K(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                } else if (z.b(this.f62067e, "com.tencent.mobileqq")) {
                    x("share_to_qzone", new Object[0]);
                    y(4);
                    ShareItem k4 = k(4);
                    B(k4, 5);
                    if (k4 != null) {
                        gVar.i(k4);
                    }
                } else {
                    Context context = this.f62067e;
                    BdToast.c(context, context.getText(R.string.share_qq_not_install)).q();
                }
            } else if (intValue == 6) {
                if (!j.z()) {
                    l.K(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    return;
                }
                x("share_to_qweibo", new Object[0]);
                y(5);
                ShareItem k5 = k(5);
                B(k5, 6);
                if (k5 != null) {
                    if (!k5.f13711a) {
                        k5.s = i(k5);
                    }
                    gVar.l(k5);
                }
            } else if (intValue == 7) {
                if (!j.z()) {
                    l.K(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    return;
                }
                x("share_to_sweibo", new Object[0]);
                y(6);
                ShareItem k6 = k(6);
                B(k6, 7);
                if (k6 != null) {
                    if (!k6.f13711a) {
                        k6.s = i(k6);
                    }
                    gVar.k(k6);
                }
            } else if (intValue == 8) {
                if (!j.z()) {
                    l.K(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    return;
                }
                x("share_to_renren", new Object[0]);
                y(7);
                ShareItem k7 = k(7);
                B(k7, 8);
                if (k7 != null) {
                    if (!k7.f13711a) {
                        k7.s = i(k7);
                    }
                    gVar.j(k7);
                }
            } else if (intValue != 9) {
                if (intValue == 10) {
                    B(k, 10);
                    View.OnClickListener onClickListener = this.k;
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    } else {
                        d.b.b.e.p.a.a(k.t);
                        l.L(this.f62067e.getApplicationContext(), this.f62067e.getResources().getString(R.string.copy_pb_url_success));
                    }
                    z(k);
                    if (k == null || !k.f13711a) {
                        return;
                    }
                    A(8, k.B);
                }
            } else if (!j.z()) {
                l.K(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
            } else if (z.b(this.f62067e, "com.tencent.mobileqq")) {
                x("share_to_qq_friend", new Object[0]);
                y(8);
                ShareItem k8 = k(8);
                B(k8, 9);
                if (k8 != null) {
                    gVar.h(k8);
                }
            } else {
                Context context2 = this.f62067e;
                BdToast.c(context2, context2.getText(R.string.share_qq_not_install)).q();
            }
        }
    }

    public final boolean p(int i) {
        return (i & 1) > 0;
    }

    public final boolean q(int i) {
        return (i & 2) > 0;
    }

    public final boolean r(int i) {
        return (i & 16) > 0;
    }

    public final void s() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001277, new C1642a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void u(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.k = onClickListener;
        }
    }

    public void v(ShareItem shareItem, boolean z) {
        Location j;
        if (z && (j = j()) != null) {
            shareItem.A = j;
        }
        this.n.put(1, shareItem);
    }

    public void w() {
        if (!j.z()) {
            l.K(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
        } else if (!g.g()) {
            l.K(TbadkCoreApplication.getInst().getContext(), R.string.plugin_share_install_failure);
        } else {
            d();
            AlertDialog create = new AlertDialog.Builder(this.f62067e, R.style.DialogTheme).create();
            this.m = create;
            create.setCanceledOnTouchOutside(true);
            this.m.setOnDismissListener(new b());
            Context context = this.f62067e;
            if (context instanceof Activity) {
                d.b.b.e.m.g.i(this.m, (Activity) context);
            }
            this.f62068f.setBackgroundResource(R.drawable.transmit_share_dialog_background);
            Window window = this.m.getWindow();
            window.addFlags(512);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = l.g(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.f62068f);
            e();
            s();
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
        }
    }

    public final void x(String str, Object... objArr) {
        TiebaStatic.eventStat(this.f62067e, str, PrefetchEvent.STATE_CLICK, 1, objArr);
    }

    public final void y(int i) {
        if (i > 8 || i <= 0) {
            return;
        }
        this.o = true;
        SparseArray<d0> sparseArray = this.q;
        if (sparseArray != null) {
            d0 d0Var = sparseArray.get(i);
            if (!StringUtils.isNull(d0Var.b()) && d0Var.a() != null && d0Var.a().size() > 0) {
                x(d0Var.b(), d0Var.a());
                return;
            }
        }
        SparseArray<String> sparseArray2 = this.p;
        if (sparseArray2 != null) {
            String str = sparseArray2.get(i);
            if (k.isEmpty(str)) {
                return;
            }
            x(str, new Object[0]);
        }
    }

    public final void z(ShareItem shareItem) {
        StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 9);
        int i = shareItem.E;
        if (i != 0) {
            param.param("obj_param1", i);
            int i2 = shareItem.E;
            if (i2 == 2) {
                param.param("fid", shareItem.I);
            } else if (i2 == 3) {
                int i3 = shareItem.L;
                if (i3 != 0) {
                    param.param("obj_type", i3);
                }
                param.param("tid", shareItem.J).param("fid", shareItem.I);
            }
        }
        param.param("obj_locate", 7);
        TiebaStatic.log(param);
    }
}
