package d.a.j0.w2.g;

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
import d.a.c.e.p.j;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.i0.s.c.f0;
import d.a.i0.s.g.g;
import d.a.j0.d3.z;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a implements View.OnClickListener {
    public static final int r = (int) ((l.k(TbadkCoreApplication.getInst()) - (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) * 0.2d);
    public static final int s = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    public static final int t = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    public static final int u = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    public static final int v = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    public static final int w = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds30);

    /* renamed from: e  reason: collision with root package name */
    public final Context f62413e;

    /* renamed from: f  reason: collision with root package name */
    public final View f62414f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f62415g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f62416h;

    /* renamed from: i  reason: collision with root package name */
    public ShareGridLayout f62417i;
    public View.OnClickListener k;
    public DialogInterface.OnDismissListener l;
    public AlertDialog m;
    public SparseArray<String> p;
    public SparseArray<f0> q;
    public final SparseArray<ShareItem> n = new SparseArray<>(8);
    public boolean o = false;
    public final List<View> j = new ArrayList();

    /* renamed from: d.a.j0.w2.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1660a implements CustomMessageTask.CustomRunnable<Object> {
        public C1660a() {
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
        public View.OnClickListener f62420e;

        public c(View.OnClickListener onClickListener) {
            this.f62420e = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f();
            View.OnClickListener onClickListener = this.f62420e;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    public a(Context context, boolean z, int i2) {
        this.f62413e = context;
        View inflate = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.ala_share_dialog_content, (ViewGroup) null);
        this.f62414f = inflate;
        this.f62416h = (TextView) inflate.findViewById(R.id.share_dialog_title);
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.f62416h.setText(sharePanelText);
        }
        ShareGridLayout shareGridLayout = (ShareGridLayout) this.f62414f.findViewById(R.id.share_grid_layout);
        this.f62417i = shareGridLayout;
        ViewGroup.LayoutParams layoutParams = shareGridLayout.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i3 = ShareGridLayout.j;
            marginLayoutParams.leftMargin = i3;
            marginLayoutParams.rightMargin = i3;
            this.f62417i.setLayoutParams(marginLayoutParams);
        }
        this.f62417i.setItemParams(r, s);
        TextView textView = (TextView) this.f62414f.findViewById(R.id.btnShareCancel);
        this.f62415g = textView;
        textView.setOnClickListener(this);
        if (!o(i2)) {
            m(new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4);
        }
        if (!p(i2)) {
            m(new SvgMaskType(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3);
        }
        if (!n(i2)) {
            m(new SvgMaskType(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9);
        }
        if (!q(i2)) {
            m(new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7);
        }
        if (g.g()) {
            return;
        }
        this.f62417i.setVisibility(8);
    }

    public void c(View view, int i2, View.OnClickListener onClickListener) {
        if (i2 > this.j.size() || i2 < 0) {
            return;
        }
        this.j.add(i2, view);
        if (onClickListener != null) {
            view.setOnClickListener(new c(onClickListener));
        }
    }

    public void d() {
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            this.f62417i.addView(this.j.get(i2), new ViewGroup.LayoutParams(r, s));
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void e() {
    }

    public void f() {
        AlertDialog alertDialog = this.m;
        if (alertDialog != null) {
            this.o = false;
            Context context = this.f62413e;
            if (context instanceof Activity) {
                d.a.c.e.m.g.a(alertDialog, (Activity) context);
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
            }
        }
    }

    public int g() {
        List<View> list = this.j;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final String h(ShareItem shareItem) {
        String str = "【" + shareItem.r + "】 " + shareItem.s;
        shareItem.s = str;
        return str;
    }

    public final Location i() {
        if (PermissionUtil.checkLocationForGoogle(this.f62413e)) {
            LocationManager locationManager = (LocationManager) this.f62413e.getSystemService("location");
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

    public final ShareItem j(int i2) {
        ShareItem shareItem = this.n.get(i2);
        return shareItem == null ? this.n.get(1) : shareItem;
    }

    public void k(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.l = onDismissListener;
        }
    }

    public LinearLayout l(int i2, int i3) {
        LinearLayout linearLayout = new LinearLayout(this.f62413e);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i3));
        ImageView imageView = new ImageView(this.f62413e);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0213).into(imageView);
        int i4 = t;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i4, i4);
        layoutParams.topMargin = u;
        layoutParams.bottomMargin = v;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.f62413e);
        textView.setTextSize(0, w);
        textView.setText(i2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        imageView.setImageResource(i3);
        textView.setTextColor(this.f62413e.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
        return linearLayout;
    }

    public final void m(AbsSvgType absSvgType, int i2, int i3) {
        if (absSvgType == null) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(this.f62413e);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i3));
        ImageView imageView = new ImageView(this.f62413e);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (absSvgType instanceof SvgPureType) {
            TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0213).into(imageView);
        }
        int i4 = t;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i4, i4);
        layoutParams.topMargin = u;
        layoutParams.bottomMargin = v;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.f62413e);
        textView.setTextSize(0, w);
        textView.setText(i2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        imageView.setImageDrawable(absSvgType.getDrawable());
        textView.setTextColor(this.f62413e.getResources().getColorStateList(R.color.share_channel_item_txt_selector));
        linearLayout.setOnClickListener(this);
        this.j.add(linearLayout);
    }

    public final boolean n(int i2) {
        return (i2 & 8) > 0;
    }

    public final boolean o(int i2) {
        return (i2 & 1) > 0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        int intValue = view.getTag() != null ? ((Integer) view.getTag()).intValue() : -1;
        if (this.n.size() == 0) {
            return;
        }
        if (view.getId() == R.id.btnShareCancel || !this.o) {
            this.o = true;
            g gVar = new g(this.f62413e, null);
            ShareItem j = j(1);
            if (id == R.id.btnShareCancel) {
                v("share_cancel", new Object[0]);
                f();
                return;
            }
            if (intValue == 4) {
                if (!j.z()) {
                    l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    return;
                }
                v("share_to_weixin", new Object[0]);
                w(3);
                ShareItem j2 = j(3);
                z(j2, 4);
                if (j2 != null) {
                    gVar.m(j2);
                }
            } else if (intValue == 3) {
                if (!j.z()) {
                    l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    return;
                }
                v("share_to_pyq", new Object[0]);
                w(2);
                ShareItem j3 = j(2);
                z(j3, 3);
                if (j3 != null) {
                    if (j3.f13352b) {
                        j3.s = "【" + j3.r + "】 " + j3.s;
                    }
                    gVar.n(j3);
                }
            } else if (intValue == 5) {
                if (!j.z()) {
                    l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    return;
                } else if (z.b(this.f62413e, "com.tencent.mobileqq")) {
                    v("share_to_qzone", new Object[0]);
                    w(4);
                    ShareItem j4 = j(4);
                    z(j4, 5);
                    if (j4 != null) {
                        gVar.i(j4);
                    }
                } else {
                    Context context = this.f62413e;
                    BdToast.c(context, context.getText(R.string.share_qq_not_install)).q();
                }
            } else if (intValue == 6) {
                if (!j.z()) {
                    l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    return;
                }
                v("share_to_qweibo", new Object[0]);
                w(5);
                ShareItem j5 = j(5);
                z(j5, 6);
                if (j5 != null) {
                    if (!j5.f13351a) {
                        j5.s = h(j5);
                    }
                    gVar.l(j5);
                }
            } else if (intValue == 7) {
                if (!j.z()) {
                    l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    return;
                }
                v("share_to_sweibo", new Object[0]);
                w(6);
                ShareItem j6 = j(6);
                z(j6, 7);
                if (j6 != null) {
                    if (!j6.f13351a) {
                        j6.s = h(j6);
                    }
                    gVar.k(j6);
                }
            } else if (intValue == 8) {
                if (!j.z()) {
                    l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    return;
                }
                v("share_to_renren", new Object[0]);
                w(7);
                ShareItem j7 = j(7);
                z(j7, 8);
                if (j7 != null) {
                    if (!j7.f13351a) {
                        j7.s = h(j7);
                    }
                    gVar.j(j7);
                }
            } else if (intValue == 9) {
                if (!j.z()) {
                    l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    return;
                } else if (z.b(this.f62413e, "com.tencent.mobileqq")) {
                    v("share_to_qq_friend", new Object[0]);
                    w(8);
                    ShareItem j8 = j(8);
                    z(j8, 9);
                    if (j8 != null) {
                        gVar.h(j8);
                    }
                } else {
                    Context context2 = this.f62413e;
                    BdToast.c(context2, context2.getText(R.string.share_qq_not_install)).q();
                }
            } else if (intValue == 10) {
                z(j, 10);
                View.OnClickListener onClickListener = this.k;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                } else {
                    d.a.c.e.p.a.a(j.t);
                    l.M(this.f62413e.getApplicationContext(), this.f62413e.getResources().getString(R.string.copy_pb_url_success));
                }
                x(j);
                if (j != null && j.f13351a) {
                    y(8, j.C);
                }
            }
            f();
        }
    }

    public final boolean p(int i2) {
        return (i2 & 2) > 0;
    }

    public final boolean q(int i2) {
        return (i2 & 16) > 0;
    }

    public final void r() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001277, new C1660a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void s(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.k = onClickListener;
        }
    }

    public void t(ShareItem shareItem, boolean z) {
        Location i2;
        if (z && (i2 = i()) != null) {
            shareItem.B = i2;
        }
        this.n.put(1, shareItem);
    }

    public void u() {
        if (!j.z()) {
            l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
        } else if (!g.g()) {
            l.L(TbadkCoreApplication.getInst().getContext(), R.string.plugin_share_install_failure);
        } else {
            d();
            AlertDialog create = new AlertDialog.Builder(this.f62413e, R.style.DialogTheme).create();
            this.m = create;
            create.setCanceledOnTouchOutside(true);
            this.m.setOnDismissListener(new b());
            Context context = this.f62413e;
            if (context instanceof Activity) {
                d.a.c.e.m.g.i(this.m, (Activity) context);
            }
            this.f62414f.setBackgroundResource(R.drawable.transmit_share_dialog_background);
            Window window = this.m.getWindow();
            window.addFlags(512);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = l.g(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.f62414f);
            e();
            r();
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
        }
    }

    public final void v(String str, Object... objArr) {
        TiebaStatic.eventStat(this.f62413e, str, PrefetchEvent.STATE_CLICK, 1, objArr);
    }

    public final void w(int i2) {
        if (i2 > 8 || i2 <= 0) {
            return;
        }
        this.o = true;
        SparseArray<f0> sparseArray = this.q;
        if (sparseArray != null) {
            f0 f0Var = sparseArray.get(i2);
            if (!StringUtils.isNull(f0Var.b()) && f0Var.a() != null && f0Var.a().size() > 0) {
                v(f0Var.b(), f0Var.a());
                return;
            }
        }
        SparseArray<String> sparseArray2 = this.p;
        if (sparseArray2 != null) {
            String str = sparseArray2.get(i2);
            if (k.isEmpty(str)) {
                return;
            }
            v(str, new Object[0]);
        }
    }

    public final void x(ShareItem shareItem) {
        StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 9);
        int i2 = shareItem.F;
        if (i2 != 0) {
            param.param("obj_param1", i2);
            int i3 = shareItem.F;
            if (i3 == 2) {
                param.param("fid", shareItem.J);
            } else if (i3 == 3) {
                int i4 = shareItem.M;
                if (i4 != 0) {
                    param.param("obj_type", i4);
                }
                param.param("tid", shareItem.K).param("fid", shareItem.J);
            }
        }
        param.param("obj_locate", 7);
        TiebaStatic.log(param);
    }

    public final void y(int i2, String str) {
        TiebaStatic.eventStat(this.f62413e, "pb_new_share", null, 1, "loc", Integer.valueOf(i2), PbChosenActivityConfig.KEY_TID, str);
    }

    public final void z(ShareItem shareItem, int i2) {
        if (shareItem == null || shareItem.q == null) {
            return;
        }
        if (shareItem.f13352b) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", shareItem.q).param("obj_type", i2));
        } else if (!shareItem.f13353c && !shareItem.f13356f) {
            if (shareItem.f13354d) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).param("tid", shareItem.q).param("obj_type", i2));
            } else if (shareItem.f13351a) {
                y(i2, shareItem.C);
            } else if (shareItem.f13355e) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", 7).param("obj_type", i2).param("fid", shareItem.q));
            } else if (shareItem.f13357g) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i2);
                if (!k.isEmpty(shareItem.t) && shareItem.t.contains("worldcup")) {
                    param.param("obj_param1", 9);
                }
                TiebaStatic.log(param);
            }
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("tid", shareItem.q).param("obj_type", i2).param("obj_source", shareItem.E).param("obj_param1", shareItem.F).param("fid", shareItem.J));
        }
    }
}
