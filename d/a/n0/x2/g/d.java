package d.a.n0.x2.g;

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
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.svg.AbsSvgType;
import com.baidu.tbadk.core.util.svg.SvgMaskType;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.sharesdk.view.ShareDialogItemView;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.c.e.p.j;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.m0.r.s.a;
import d.a.m0.s.c.f0;
import d.a.m0.s.c.g0;
import d.a.m0.z0.q;
import d.a.n0.e3.z;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/* loaded from: classes5.dex */
public class d implements View.OnClickListener {
    public static final int A = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds202);
    public static final int B = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds239);

    /* renamed from: e  reason: collision with root package name */
    public final Context f63331e;

    /* renamed from: f  reason: collision with root package name */
    public final View f63332f;

    /* renamed from: g  reason: collision with root package name */
    public final View f63333g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f63334h;

    /* renamed from: i  reason: collision with root package name */
    public ShareGridLayout f63335i;
    public final EMTextView j;
    public final List<View> k;
    public View.OnClickListener l;
    public DialogInterface.OnDismissListener m;
    public DialogInterface.OnCancelListener n;
    public AlertDialog o;
    public float p;
    public PermissionJudgePolicy q;
    public final SparseArray<ShareItem> r;
    public boolean s;
    public SparseArray<String> t;
    public SparseArray<g0> u;
    public boolean v;
    public int w;
    public boolean x;
    public CustomMessageListener y;
    public int z;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                d.this.k();
                d.this.f63335i.removeAllViews();
                d.this.j();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements CustomMessageTask.CustomRunnable<Object> {
        public b() {
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            if (d.this.o == null || !d.this.o.isShowing()) {
                return null;
            }
            d.this.m();
            return null;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements DialogInterface.OnDismissListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (d.this.m != null) {
                d.this.m.onDismiss(dialogInterface);
            }
            MessageManager.getInstance().unRegisterTask(2001277);
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
        }
    }

    /* renamed from: d.a.n0.x2.g.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class DialogInterface$OnCancelListenerC1743d implements DialogInterface.OnCancelListener {
        public DialogInterface$OnCancelListenerC1743d() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (d.this.n != null) {
                d.this.n.onCancel(dialogInterface);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends q.a {
        public e() {
        }

        @Override // d.a.m0.z0.q.a
        public void onError(int i2, String str) {
            l.M(d.this.f63331e, "保存失败！");
        }

        @Override // d.a.m0.z0.q.a
        public void onSuccess(String str) {
            l.M(d.this.f63331e, "保存成功！");
        }
    }

    /* loaded from: classes5.dex */
    public class f implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f63341e;

        public f(ShareItem shareItem) {
            this.f63341e = shareItem;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            d.a.c.e.p.a.a(this.f63341e.s);
            l.L(d.this.f63331e.getApplicationContext(), R.string.copy_success);
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class g implements a.e {
        public g(d dVar) {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public View.OnClickListener f63343e;

        public h(View.OnClickListener onClickListener) {
            this.f63343e = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.m();
            View.OnClickListener onClickListener = this.f63343e;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    public d(Context context, boolean z, int i2) {
        this.p = 0.33f;
        this.r = new SparseArray<>(8);
        this.s = false;
        this.v = true;
        this.w = 1;
        this.x = true;
        this.y = new a(2001304);
        this.z = 0;
        this.z = i2;
        this.f63331e = context;
        this.k = new ArrayList();
        View p = p();
        this.f63332f = p;
        this.f63333g = p.findViewById(R.id.share_dialog_main_view);
        this.f63334h = (TextView) this.f63332f.findViewById(R.id.share_dialog_title);
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.f63334h.setText(sharePanelText);
        }
        ShareGridLayout shareGridLayout = (ShareGridLayout) this.f63332f.findViewById(R.id.share_grid_layout);
        this.f63335i = shareGridLayout;
        ViewGroup.LayoutParams layoutParams = shareGridLayout.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i3 = ShareGridLayout.j;
            marginLayoutParams.leftMargin = i3;
            marginLayoutParams.rightMargin = i3;
            this.f63335i.setLayoutParams(marginLayoutParams);
        }
        this.f63335i.setItemParams(A, B);
        EMTextView eMTextView = (EMTextView) this.f63332f.findViewById(R.id.btnShareCancel);
        this.j = eMTextView;
        eMTextView.setOnClickListener(this);
    }

    public final boolean A(int i2) {
        return (i2 & 32) > 0;
    }

    public void B(ShareDialogConfig.From from) {
        f0 sharePanelConfData = TbSingleton.getInstance().getSharePanelConfData();
        if (sharePanelConfData != null && sharePanelConfData.d(from) && sharePanelConfData.c() && !k.isEmpty(sharePanelConfData.b())) {
            this.f63334h.setText(sharePanelConfData.b());
        }
    }

    public final void F() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001277, new b());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void G(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.l = onClickListener;
        }
    }

    public void H(int i2) {
    }

    public void I(boolean z) {
        this.v = z;
    }

    public void J(SparseArray<String> sparseArray) {
        this.t = sparseArray;
    }

    public void K(DialogInterface.OnCancelListener onCancelListener) {
        this.n = onCancelListener;
    }

    public void L(ShareItem shareItem, boolean z) {
        Location q;
        if (z && (q = q()) != null) {
            shareItem.B = q;
        }
        this.r.put(1, shareItem);
        if (StringUtils.isNull(shareItem.n)) {
            return;
        }
        this.f63334h.setText(shareItem.n);
    }

    public void M(int i2, ShareItem shareItem, boolean z) {
        Location q;
        if (z && (q = q()) != null) {
            shareItem.B = q;
        }
        this.r.put(i2, shareItem);
    }

    public void N(int i2) {
        this.w = i2;
    }

    public void O(boolean z) {
        this.x = z;
    }

    public void P(Window window) {
        window.setLayout(-1, -2);
    }

    public boolean Q() {
        return this.w == 2 && l();
    }

    public void R() {
        if (!j.z()) {
            l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
        } else if (!d.a.m0.s.g.g.g()) {
            l.L(TbadkCoreApplication.getInst().getContext(), R.string.plugin_share_install_failure);
        } else {
            j();
            AlertDialog create = new AlertDialog.Builder(this.f63331e, R.style.DialogTheme).create();
            this.o = create;
            create.setCanceledOnTouchOutside(true);
            this.o.setOnDismissListener(new c());
            this.o.setOnCancelListener(new DialogInterface$OnCancelListenerC1743d());
            Context context = this.f63331e;
            if (context instanceof Activity) {
                d.a.c.e.m.g.i(this.o, (Activity) context);
            }
            d.a.m0.r.u.c d2 = d.a.m0.r.u.c.d(this.f63333g);
            d2.m(R.string.J_X14);
            d2.f(R.color.CAM_X0204);
            Window window = this.o.getWindow();
            if (window == null) {
                return;
            }
            if (this.x) {
                window.addFlags(512);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.y = l.g(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
                window.setAttributes(attributes);
                window.setWindowAnimations(R.style.share_dialog_style);
            } else {
                window.setWindowAnimations(R.style.normal_dialog_style);
            }
            window.setGravity(80);
            P(window);
            window.setContentView(this.f63332f);
            window.setDimAmount(this.p);
            k();
            F();
            d.a.c.a.j.a(this.f63331e).registerListener(this.y);
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
        }
    }

    public final void S() {
        ArrayList arrayList = new ArrayList(this.k);
        this.k.clear();
        if (!x(this.z)) {
            h(R.string.share_weixin, new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg));
        }
        if (!y(this.z)) {
            h(R.string.share_weixin_timeline, new SvgMaskType(R.drawable.icon_mask_share_circle40_svg));
        }
        if (!v(this.z)) {
            h(R.string.share_qq_friends, new SvgMaskType(R.drawable.icon_mask_share_qq40_svg));
        }
        if (!w(this.z)) {
            h(R.string.share_qzone, new SvgMaskType(R.drawable.icon_mask_share_qqzone40_svg));
        }
        if (!z(this.z)) {
            h(R.string.share_sina_weibo, new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg));
        }
        if (A(this.z)) {
            g(R.string.share_save_pic, R.drawable.icon_pure_share_download40);
        }
        if (arrayList.size() > 0) {
            this.k.addAll(arrayList);
        }
        if (this.v) {
            g(R.string.share_copy, R.drawable.icon_pure_share_copy40);
        }
    }

    public final void T(ShareItem shareItem) {
        if (shareItem == null || TextUtils.isEmpty(shareItem.s) || TextUtils.isEmpty(shareItem.r)) {
            return;
        }
        Context context = this.f63331e;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(activity);
            aVar.setTitle(shareItem.r);
            aVar.setMessage(shareItem.s);
            aVar.setAutoNight(false);
            aVar.setCancelable(true);
            aVar.setTitleShowCenter(true);
            aVar.setPositiveButton(R.string.share_copy, new f(shareItem));
            aVar.setNegativeButton(R.string.share_cancel, new g(this)).create(d.a.c.a.j.a(activity));
            aVar.show();
        }
    }

    public boolean V() {
        return false;
    }

    public final void W(String str, Object... objArr) {
        TiebaStatic.eventStat(this.f63331e, str, PrefetchEvent.STATE_CLICK, 1, objArr);
    }

    public final void X(int i2) {
        if (i2 > 8 || i2 <= 0) {
            return;
        }
        this.s = true;
        SparseArray<g0> sparseArray = this.u;
        if (sparseArray != null) {
            g0 g0Var = sparseArray.get(i2);
            if (!StringUtils.isNull(g0Var.b()) && g0Var.a() != null && g0Var.a().size() > 0) {
                W(g0Var.b(), g0Var.a());
                return;
            }
        }
        SparseArray<String> sparseArray2 = this.t;
        if (sparseArray2 != null) {
            String str = sparseArray2.get(i2);
            if (k.isEmpty(str)) {
                return;
            }
            W(str, new Object[0]);
        }
    }

    public final void Y(ShareItem shareItem) {
        StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 7);
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
        param.param("obj_locate", 9);
        TiebaStatic.log(param);
    }

    public final void Z(int i2, String str) {
        TiebaStatic.eventStat(this.f63331e, "pb_new_share", null, 1, "loc", Integer.valueOf(i2), PbChosenActivityConfig.KEY_TID, str);
    }

    public final void a0(ShareItem shareItem, int i2) {
        if (shareItem == null) {
            return;
        }
        if (shareItem.q == null) {
            if (shareItem.j) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i2).param("obj_source", shareItem.E));
            }
        } else if (shareItem.f12596b) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", shareItem.q).param("obj_type", i2).param("obj_source", shareItem.E).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.G));
        } else if (!shareItem.f12597c && !shareItem.f12600f) {
            if (shareItem.f12598d) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).param("tid", shareItem.q).param("obj_type", i2));
            } else if (shareItem.f12595a) {
                Z(i2, shareItem.C);
            } else if (shareItem.f12599e) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", 7).param("obj_type", i2).param("fid", shareItem.q).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.G));
            } else if (shareItem.f12601g) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i2);
                param.param("obj_source", shareItem.E);
                if (!k.isEmpty(shareItem.t)) {
                    if (shareItem.t.contains("worldcup")) {
                        param.param("obj_param1", 9);
                    }
                    param.param(TiebaStatic.Params.OBJ_URL, shareItem.t);
                }
                TiebaStatic.log(param);
            } else if (shareItem.f12603i) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_TOPIC_DETAIL).param("obj_locate", i2 == 3 ? "1" : i2 == 4 ? "2" : i2 == 9 ? "4" : i2 == 5 ? "3" : i2 == 7 ? "5" : "6").param("topic_id", shareItem.q));
            } else if (shareItem.k) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD);
                statisticItem.param("tid", shareItem.q);
                statisticItem.param("post_id", shareItem.V);
                statisticItem.param("obj_source", 18);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, shareItem.G);
                TiebaStatic.log(statisticItem);
            } else if (shareItem.l) {
                StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_GAME_DETIAL);
                statisticItem2.param("obj_type", i2);
                statisticItem2.param("obj_name", shareItem.r);
                TiebaStatic.log(statisticItem2);
            }
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("tid", shareItem.q).param("obj_type", i2).param("obj_source", shareItem.E).param("obj_param1", shareItem.F).param("fid", shareItem.J).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.G));
        }
    }

    public void g(int i2, int i3) {
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.f63331e);
        shareDialogItemView.setItemIcon(i3, SkinManager.getColor(R.color.CAM_X0107));
        shareDialogItemView.setItemName(i2);
        shareDialogItemView.setOnClickListener(this);
        List<View> list = this.k;
        shareDialogItemView.a();
        list.add(shareDialogItemView);
    }

    public void h(int i2, AbsSvgType absSvgType) {
        if (absSvgType == null) {
            return;
        }
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.f63331e);
        shareDialogItemView.setItemIcon(absSvgType);
        shareDialogItemView.setItemName(i2);
        shareDialogItemView.setOnClickListener(this);
        List<View> list = this.k;
        shareDialogItemView.a();
        list.add(shareDialogItemView);
    }

    public void i(View view, int i2, View.OnClickListener onClickListener) {
        if (i2 > this.k.size() || i2 < 0) {
            return;
        }
        this.k.add(i2, view);
        if (onClickListener != null) {
            view.setOnClickListener(new h(onClickListener));
        }
    }

    public void j() {
        if (V()) {
            return;
        }
        S();
        if (!d.a.m0.s.g.g.g()) {
            this.f63335i.setVisibility(8);
        }
        for (int i2 = 0; i2 < this.k.size(); i2++) {
            this.f63335i.addView(this.k.get(i2), new ViewGroup.LayoutParams(A, B));
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void k() {
        d.a.m0.r.u.c d2 = d.a.m0.r.u.c.d(this.f63333g);
        d2.m(R.string.J_X14);
        d2.f(R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.f63334h, R.color.CAM_X0108, 1);
        SkinManager.setViewTextColorSelector(this.j, R.color.CAM_X0107);
    }

    public final boolean l() {
        if (this.f63331e instanceof Activity) {
            if (this.q == null) {
                this.q = new PermissionJudgePolicy();
            }
            this.q.clearRequestPermissionList();
            this.q.appendRequestPermission((Activity) this.f63331e, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
            return this.q.startRequestPermission((Activity) this.f63331e);
        }
        return false;
    }

    public void m() {
        AlertDialog alertDialog = this.o;
        if (alertDialog != null) {
            this.s = false;
            if (this.f63331e instanceof Activity) {
                DialogInterface.OnDismissListener onDismissListener = this.m;
                if (onDismissListener != null) {
                    onDismissListener.onDismiss(alertDialog);
                }
                d.a.c.e.m.g.a(this.o, (Activity) this.f63331e);
                MessageManager.getInstance().unRegisterListener(this.y);
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
            }
        }
    }

    public int n() {
        List<View> list = this.k;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final String o(ShareItem shareItem) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(shareItem.r)) {
            sb.append("【");
            sb.append(shareItem.r);
            sb.append("】 ");
        }
        if (!TextUtils.isEmpty(shareItem.r)) {
            sb.append(shareItem.s);
        }
        return sb.toString();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        int intValue = view.getTag() != null ? ((Integer) view.getTag()).intValue() : -1;
        if (id != R.id.btnShareCancel && intValue != R.drawable.icon_pure_share_copy40 && Q()) {
            this.s = false;
            return;
        }
        if (intValue != R.drawable.icon_pure_share_download40) {
            m();
        }
        if (this.r.size() == 0) {
            return;
        }
        if (id == R.id.btnShareCancel || !this.s) {
            this.s = true;
            ShareItem r = r(1);
            d.a.m0.s.g.g gVar = new d.a.m0.s.g.g(this.f63331e, null);
            if (r != null && r.g0) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_AI_APP_SHARE_CLICK).param("obj_id", r.h0).param("obj_type", r.i0).param("obj_source", r.j0));
            }
            if (id == R.id.btnShareCancel) {
                W("share_cancel", new Object[0]);
                if (r != null && r.f12601g) {
                    a0(r, 16);
                }
                DialogInterface.OnCancelListener onCancelListener = this.n;
                if (onCancelListener != null) {
                    onCancelListener.onCancel(this.o);
                    return;
                }
                return;
            }
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.THREAD_ACHIEVEMENT_DETAIL_SHARE);
            if (intValue == R.drawable.icon_mask_share_wechat40_svg) {
                if (!j.z()) {
                    l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    return;
                }
                W("share_to_weixin", new Object[0]);
                X(3);
                ShareItem r2 = r(3);
                a0(r2, 4);
                if (r2 != null) {
                    if (u(r2) && r2.a() != null && r2.a().contains(3)) {
                        d.a.m0.s.g.a.e(r2, this.f63331e, 3, this.n);
                    } else if (r2.d0 == 1) {
                        T(r2);
                    } else {
                        gVar.m(r2);
                    }
                }
                statisticItem.param("obj_type", 2);
            } else if (intValue == R.drawable.icon_mask_share_circle40_svg) {
                if (!j.z()) {
                    l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    return;
                }
                W("share_to_pyq", new Object[0]);
                X(2);
                ShareItem r3 = r(2);
                a0(r3, 3);
                if (r3 != null) {
                    if (u(r3) && r3.a() != null && r3.a().contains(2)) {
                        d.a.m0.s.g.a.e(r3, this.f63331e, 2, this.n);
                    } else if (r3.d0 == 1) {
                        T(r3);
                    } else {
                        if (r3.f12596b) {
                            r3.s = "【" + r3.r + "】 " + r3.s;
                        }
                        gVar.n(r3);
                    }
                }
                statisticItem.param("obj_type", 3);
            } else if (intValue == R.drawable.icon_mask_share_qqzone40_svg) {
                if (!j.z()) {
                    l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    return;
                }
                if (z.b(this.f63331e, "com.tencent.mobileqq")) {
                    W("share_to_qzone", new Object[0]);
                    X(4);
                    ShareItem r4 = r(4);
                    a0(r4, 5);
                    if (r4 != null) {
                        if (u(r4) && r4.a() != null && r4.a().contains(4)) {
                            d.a.m0.s.g.a.e(r4, this.f63331e, 4, this.n);
                        } else {
                            gVar.i(r4);
                        }
                    }
                } else {
                    Context context = this.f63331e;
                    BdToast.c(context, context.getText(R.string.share_qq_not_install)).q();
                }
                statisticItem.param("obj_type", 5);
            } else if (intValue == R.drawable.icon_qq_weibo) {
                if (!j.z()) {
                    l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    return;
                }
                W("share_to_qweibo", new Object[0]);
                X(5);
                ShareItem r5 = r(5);
                if (r5 != null) {
                    if (!r5.f12595a) {
                        r5.s = o(r5);
                    }
                    gVar.l(r5);
                }
            } else if (intValue == R.drawable.icon_mask_share_weibo40_svg) {
                if (!j.z()) {
                    l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    return;
                }
                W("share_to_sweibo", new Object[0]);
                X(6);
                ShareItem r6 = r(6);
                a0(r6, 7);
                if (r6 != null) {
                    if (!r6.f12595a) {
                        r6.s = o(r6);
                    }
                    if (u(r6) && r6.a() != null && r6.a().contains(4)) {
                        d.a.m0.s.g.a.e(r6, this.f63331e, 6, this.n);
                    } else {
                        gVar.k(r6);
                    }
                }
                statisticItem.param("obj_type", 6);
            } else if (intValue == R.drawable.icon_renren) {
                if (!j.z()) {
                    l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    return;
                }
                W("share_to_renren", new Object[0]);
                X(7);
                ShareItem r7 = r(7);
                if (r7 != null) {
                    if (!r7.f12595a) {
                        r7.s = o(r7);
                    }
                    gVar.j(r7);
                }
            } else if (intValue == R.drawable.icon_mask_share_qq40_svg) {
                if (!j.z()) {
                    l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    return;
                }
                if (z.b(this.f63331e, "com.tencent.mobileqq")) {
                    W("share_to_qq_friend", new Object[0]);
                    X(8);
                    ShareItem r8 = r(8);
                    a0(r8, 9);
                    if (r8 != null) {
                        if (u(r8) && r8.a() != null && r8.a().contains(4)) {
                            d.a.m0.s.g.a.e(r8, this.f63331e, 8, this.n);
                        } else {
                            gVar.h(r8);
                        }
                    }
                } else {
                    Context context2 = this.f63331e;
                    BdToast.c(context2, context2.getText(R.string.share_qq_not_install)).q();
                }
                statisticItem.param("obj_type", 4);
            } else if (intValue == R.drawable.icon_pure_share_download40) {
                if (this.q == null) {
                    this.q = new PermissionJudgePolicy();
                }
                this.q.clearRequestPermissionList();
                this.q.appendRequestPermission((Activity) this.f63331e, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                if (this.q.startRequestPermission((Activity) this.f63331e)) {
                    this.s = false;
                    return;
                }
                m();
                a0(r, 17);
                if (FileHelper.isLocalFile(r.v)) {
                    if (FileHelper.copyImageFile(FileHelper.getImageRealPathFromUri(this.f63331e, r.v), UUID.randomUUID().toString().replace("-", "").toLowerCase(), this.f63331e) == 0) {
                        l.M(this.f63331e, "保存成功！");
                    } else {
                        l.M(this.f63331e, "保存失败！");
                    }
                } else {
                    String uri = r.v.toString();
                    Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                    if (currentActivity == null) {
                        return;
                    }
                    new q(currentActivity, uri, new e()).execute(new String[0]);
                }
                statisticItem.param("obj_type", 1);
            } else if (intValue == R.drawable.icon_pure_share_copy40) {
                a0(r, 10);
                View.OnClickListener onClickListener = this.l;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                } else {
                    d.a.c.e.p.a.a(r.t);
                    l.M(this.f63331e.getApplicationContext(), this.f63331e.getResources().getString(R.string.copy_pb_url_success));
                }
                Y(r);
                if (r != null && r.f12595a) {
                    Z(8, r.C);
                }
            }
            statisticItem.param("obj_source", 6);
            TiebaStatic.log(statisticItem);
        }
    }

    public View p() {
        return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.default_share_dialog_layout, (ViewGroup) null);
    }

    public final Location q() {
        if (PermissionUtil.checkLocationForGoogle(this.f63331e)) {
            LocationManager locationManager = (LocationManager) this.f63331e.getSystemService("location");
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

    public ShareItem r(int i2) {
        ShareItem shareItem = this.r.get(i2);
        return shareItem == null ? this.r.get(1) : shareItem;
    }

    public void s(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.m = onDismissListener;
        }
    }

    public LinearLayout t(int i2, int i3) {
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.f63331e);
        shareDialogItemView.setItemIcon(i3, SkinManager.getColor(R.color.CAM_X0107));
        shareDialogItemView.setItemName(i2);
        shareDialogItemView.a();
        return shareDialogItemView;
    }

    public final boolean u(ShareItem shareItem) {
        return (TextUtils.isEmpty(shareItem.m0) || TextUtils.isEmpty(shareItem.n0)) ? false : true;
    }

    public final boolean v(int i2) {
        return (i2 & 8) > 0;
    }

    public final boolean w(int i2) {
        return (i2 & 4) > 0;
    }

    public final boolean x(int i2) {
        return (i2 & 1) > 0;
    }

    public final boolean y(int i2) {
        return (i2 & 2) > 0;
    }

    public final boolean z(int i2) {
        return (i2 & 16) > 0;
    }

    public d(Context context) {
        this(context, false, 0);
    }
}
