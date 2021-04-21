package d.b.j0.w2.g;

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
import d.b.c.e.p.j;
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import d.b.i0.r.s.a;
import d.b.i0.s.c.e0;
import d.b.i0.s.c.f0;
import d.b.i0.z0.q;
import d.b.j0.d3.z;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/* loaded from: classes4.dex */
public class d implements View.OnClickListener {
    public static final int A = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds202);
    public static final int B = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds239);

    /* renamed from: e  reason: collision with root package name */
    public final Context f64163e;

    /* renamed from: f  reason: collision with root package name */
    public final View f64164f;

    /* renamed from: g  reason: collision with root package name */
    public final View f64165g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f64166h;
    public ShareGridLayout i;
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
    public SparseArray<f0> u;
    public boolean v;
    public int w;
    public boolean x;
    public CustomMessageListener y;
    public int z;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                d.this.k();
                d.this.i.removeAllViews();
                d.this.j();
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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

    /* renamed from: d.b.j0.w2.g.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class DialogInterface$OnCancelListenerC1724d implements DialogInterface.OnCancelListener {
        public DialogInterface$OnCancelListenerC1724d() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (d.this.n != null) {
                d.this.n.onCancel(dialogInterface);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends q.a {
        public e() {
        }

        @Override // d.b.i0.z0.q.a
        public void onError(int i, String str) {
            l.L(d.this.f64163e, "保存失败！");
        }

        @Override // d.b.i0.z0.q.a
        public void onSuccess(String str) {
            l.L(d.this.f64163e, "保存成功！");
        }
    }

    /* loaded from: classes4.dex */
    public class f implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f64172e;

        public f(ShareItem shareItem) {
            this.f64172e = shareItem;
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            d.b.c.e.p.a.a(this.f64172e.s);
            l.K(d.this.f64163e.getApplicationContext(), R.string.copy_success);
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class g implements a.e {
        public g(d dVar) {
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public View.OnClickListener f64174e;

        public h(View.OnClickListener onClickListener) {
            this.f64174e = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.m();
            View.OnClickListener onClickListener = this.f64174e;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    public d(Context context, boolean z, int i) {
        this.p = 0.33f;
        this.r = new SparseArray<>(8);
        this.s = false;
        this.v = true;
        this.w = 1;
        this.x = true;
        this.y = new a(2001304);
        this.z = 0;
        this.z = i;
        this.f64163e = context;
        this.k = new ArrayList();
        View p = p();
        this.f64164f = p;
        this.f64165g = p.findViewById(R.id.share_dialog_main_view);
        this.f64166h = (TextView) this.f64164f.findViewById(R.id.share_dialog_title);
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.f64166h.setText(sharePanelText);
        }
        ShareGridLayout shareGridLayout = (ShareGridLayout) this.f64164f.findViewById(R.id.share_grid_layout);
        this.i = shareGridLayout;
        ViewGroup.LayoutParams layoutParams = shareGridLayout.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i2 = ShareGridLayout.j;
            marginLayoutParams.leftMargin = i2;
            marginLayoutParams.rightMargin = i2;
            this.i.setLayoutParams(marginLayoutParams);
        }
        this.i.setItemParams(A, B);
        EMTextView eMTextView = (EMTextView) this.f64164f.findViewById(R.id.btnShareCancel);
        this.j = eMTextView;
        eMTextView.setOnClickListener(this);
    }

    public final boolean A(int i) {
        return (i & 16) > 0;
    }

    public final boolean B(int i) {
        return (i & 32) > 0;
    }

    public void E(ShareDialogConfig.From from) {
        e0 sharePanelConfData = TbSingleton.getInstance().getSharePanelConfData();
        if (sharePanelConfData != null && sharePanelConfData.d(from) && sharePanelConfData.c() && !k.isEmpty(sharePanelConfData.b())) {
            this.f64166h.setText(sharePanelConfData.b());
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

    public void I(int i) {
    }

    public void J(boolean z) {
        this.v = z;
    }

    public void K(SparseArray<String> sparseArray) {
        this.t = sparseArray;
    }

    public void L(DialogInterface.OnCancelListener onCancelListener) {
        this.n = onCancelListener;
    }

    public void M(ShareItem shareItem, boolean z) {
        Location q;
        if (z && (q = q()) != null) {
            shareItem.A = q;
        }
        this.r.put(1, shareItem);
        if (StringUtils.isNull(shareItem.n)) {
            return;
        }
        this.f64166h.setText(shareItem.n);
    }

    public void O(int i, ShareItem shareItem, boolean z) {
        Location q;
        if (z && (q = q()) != null) {
            shareItem.A = q;
        }
        this.r.put(i, shareItem);
    }

    public void P(int i) {
        this.w = i;
    }

    public void Q(boolean z) {
        this.x = z;
    }

    public void R(Window window) {
        window.setLayout(-1, -2);
    }

    public boolean S() {
        return this.w == 2 && l();
    }

    public void T() {
        if (!j.z()) {
            l.K(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
        } else if (!d.b.i0.s.g.g.g()) {
            l.K(TbadkCoreApplication.getInst().getContext(), R.string.plugin_share_install_failure);
        } else {
            j();
            AlertDialog create = new AlertDialog.Builder(this.f64163e, R.style.DialogTheme).create();
            this.o = create;
            create.setCanceledOnTouchOutside(true);
            this.o.setOnDismissListener(new c());
            this.o.setOnCancelListener(new DialogInterface$OnCancelListenerC1724d());
            Context context = this.f64163e;
            if (context instanceof Activity) {
                d.b.c.e.m.g.i(this.o, (Activity) context);
            }
            d.b.i0.r.u.c d2 = d.b.i0.r.u.c.d(this.f64165g);
            d2.k(R.string.J_X14);
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
            R(window);
            window.setContentView(this.f64164f);
            window.setDimAmount(this.p);
            k();
            F();
            d.b.c.a.j.a(this.f64163e).registerListener(this.y);
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
        }
    }

    public final void U() {
        ArrayList arrayList = new ArrayList(this.k);
        this.k.clear();
        if (!y(this.z)) {
            h(R.string.share_weixin, new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg));
        }
        if (!z(this.z)) {
            h(R.string.share_weixin_timeline, new SvgMaskType(R.drawable.icon_mask_share_circle40_svg));
        }
        if (!w(this.z)) {
            h(R.string.share_qq_friends, new SvgMaskType(R.drawable.icon_mask_share_qq40_svg));
        }
        if (!x(this.z)) {
            h(R.string.share_qzone, new SvgMaskType(R.drawable.icon_mask_share_qqzone40_svg));
        }
        if (!A(this.z)) {
            h(R.string.share_sina_weibo, new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg));
        }
        if (B(this.z)) {
            g(R.string.share_save_pic, R.drawable.icon_pure_share_download40);
        }
        if (arrayList.size() > 0) {
            this.k.addAll(arrayList);
        }
        if (this.v) {
            g(R.string.share_copy, R.drawable.icon_pure_share_copy40);
        }
    }

    public final void V(ShareItem shareItem) {
        if (shareItem == null || TextUtils.isEmpty(shareItem.s) || TextUtils.isEmpty(shareItem.r)) {
            return;
        }
        Context context = this.f64163e;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(activity);
            aVar.setTitle(shareItem.r);
            aVar.setMessage(shareItem.s);
            aVar.setAutoNight(false);
            aVar.setCancelable(true);
            aVar.setTitleShowCenter(true);
            aVar.setPositiveButton(R.string.share_copy, new f(shareItem));
            aVar.setNegativeButton(R.string.share_cancel, new g(this)).create(d.b.c.a.j.a(activity));
            aVar.show();
        }
    }

    public boolean W() {
        return false;
    }

    public final void X(String str, Object... objArr) {
        TiebaStatic.eventStat(this.f64163e, str, PrefetchEvent.STATE_CLICK, 1, objArr);
    }

    public final void Y(int i) {
        if (i > 8 || i <= 0) {
            return;
        }
        this.s = true;
        SparseArray<f0> sparseArray = this.u;
        if (sparseArray != null) {
            f0 f0Var = sparseArray.get(i);
            if (!StringUtils.isNull(f0Var.b()) && f0Var.a() != null && f0Var.a().size() > 0) {
                X(f0Var.b(), f0Var.a());
                return;
            }
        }
        SparseArray<String> sparseArray2 = this.t;
        if (sparseArray2 != null) {
            String str = sparseArray2.get(i);
            if (k.isEmpty(str)) {
                return;
            }
            X(str, new Object[0]);
        }
    }

    public final void b0(ShareItem shareItem) {
        StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 7);
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
        param.param("obj_locate", 9);
        TiebaStatic.log(param);
    }

    public final void c0(int i, String str) {
        TiebaStatic.eventStat(this.f64163e, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    public final void d0(ShareItem shareItem, int i) {
        if (shareItem == null) {
            return;
        }
        if (shareItem.q == null) {
            if (shareItem.j) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i).param("obj_source", shareItem.D));
            }
        } else if (shareItem.f13382b) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", shareItem.q).param("obj_type", i).param("obj_source", shareItem.D));
        } else if (!shareItem.f13383c && !shareItem.f13386f) {
            if (shareItem.f13384d) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).param("tid", shareItem.q).param("obj_type", i));
            } else if (shareItem.f13381a) {
                c0(i, shareItem.B);
            } else if (shareItem.f13385e) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", 7).param("obj_type", i).param("fid", shareItem.q));
            } else if (shareItem.f13387g) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i);
                param.param("obj_source", shareItem.D);
                if (!k.isEmpty(shareItem.t)) {
                    if (shareItem.t.contains("worldcup")) {
                        param.param("obj_param1", 9);
                    }
                    param.param(TiebaStatic.Params.OBJ_URL, shareItem.t);
                }
                TiebaStatic.log(param);
            } else if (shareItem.i) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_TOPIC_DETAIL).param("obj_locate", i == 3 ? "1" : i == 4 ? "2" : i == 9 ? "4" : i == 5 ? "3" : i == 7 ? "5" : "6").param("topic_id", shareItem.q));
            } else if (shareItem.k) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD);
                statisticItem.param("tid", shareItem.q);
                statisticItem.param("post_id", shareItem.U);
                statisticItem.param("obj_source", 18);
                TiebaStatic.log(statisticItem);
            } else if (shareItem.l) {
                StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_GAME_DETIAL);
                statisticItem2.param("obj_type", i);
                statisticItem2.param("obj_name", shareItem.r);
                TiebaStatic.log(statisticItem2);
            }
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("tid", shareItem.q).param("obj_type", i).param("obj_source", shareItem.D).param("obj_param1", shareItem.E).param("fid", shareItem.I).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.F));
        }
    }

    public void g(int i, int i2) {
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.f64163e);
        shareDialogItemView.setItemIcon(i2, SkinManager.getColor(R.color.CAM_X0107));
        shareDialogItemView.setItemName(i);
        shareDialogItemView.setOnClickListener(this);
        List<View> list = this.k;
        shareDialogItemView.a();
        list.add(shareDialogItemView);
    }

    public void h(int i, AbsSvgType absSvgType) {
        if (absSvgType == null) {
            return;
        }
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.f64163e);
        shareDialogItemView.setItemIcon(absSvgType);
        shareDialogItemView.setItemName(i);
        shareDialogItemView.setOnClickListener(this);
        List<View> list = this.k;
        shareDialogItemView.a();
        list.add(shareDialogItemView);
    }

    public void i(View view, int i, View.OnClickListener onClickListener) {
        if (i > this.k.size() || i < 0) {
            return;
        }
        this.k.add(i, view);
        if (onClickListener != null) {
            view.setOnClickListener(new h(onClickListener));
        }
    }

    public void j() {
        if (W()) {
            return;
        }
        U();
        if (!d.b.i0.s.g.g.g()) {
            this.i.setVisibility(8);
        }
        for (int i = 0; i < this.k.size(); i++) {
            this.i.addView(this.k.get(i), new ViewGroup.LayoutParams(A, B));
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void k() {
        d.b.i0.r.u.c d2 = d.b.i0.r.u.c.d(this.f64165g);
        d2.k(R.string.J_X14);
        d2.f(R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.f64166h, R.color.CAM_X0108, 1);
        SkinManager.setViewTextColorSelector(this.j, R.color.CAM_X0107);
    }

    public final boolean l() {
        if (this.f64163e instanceof Activity) {
            if (this.q == null) {
                this.q = new PermissionJudgePolicy();
            }
            this.q.clearRequestPermissionList();
            this.q.appendRequestPermission((Activity) this.f64163e, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
            return this.q.startRequestPermission((Activity) this.f64163e);
        }
        return false;
    }

    public void m() {
        AlertDialog alertDialog = this.o;
        if (alertDialog != null) {
            this.s = false;
            if (this.f64163e instanceof Activity) {
                DialogInterface.OnDismissListener onDismissListener = this.m;
                if (onDismissListener != null) {
                    onDismissListener.onDismiss(alertDialog);
                }
                d.b.c.e.m.g.a(this.o, (Activity) this.f64163e);
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
        if (id != R.id.btnShareCancel && intValue != R.drawable.icon_pure_share_copy40 && S()) {
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
            d.b.i0.s.g.g gVar = new d.b.i0.s.g.g(this.f64163e, null);
            if (r != null && r.e0) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_AI_APP_SHARE_CLICK).param("obj_id", r.f0).param("obj_type", r.g0).param("obj_source", r.h0));
            }
            if (id == R.id.btnShareCancel) {
                X("share_cancel", new Object[0]);
                if (r != null && r.f13387g) {
                    d0(r, 16);
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
                    l.K(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    return;
                }
                X("share_to_weixin", new Object[0]);
                Y(3);
                ShareItem r2 = r(3);
                d0(r2, 4);
                if (r2 != null) {
                    if (v(r2) && r2.a() != null && r2.a().contains(3)) {
                        d.b.i0.s.g.a.e(r2, this.f64163e, 3, this.n);
                    } else if (r2.b0 == 1) {
                        V(r2);
                    } else {
                        gVar.m(r2);
                    }
                }
                statisticItem.param("obj_type", 2);
            } else if (intValue == R.drawable.icon_mask_share_circle40_svg) {
                if (!j.z()) {
                    l.K(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    return;
                }
                X("share_to_pyq", new Object[0]);
                Y(2);
                ShareItem r3 = r(2);
                d0(r3, 3);
                if (r3 != null) {
                    if (v(r3) && r3.a() != null && r3.a().contains(2)) {
                        d.b.i0.s.g.a.e(r3, this.f64163e, 2, this.n);
                    } else if (r3.b0 == 1) {
                        V(r3);
                    } else {
                        if (r3.f13382b) {
                            r3.s = "【" + r3.r + "】 " + r3.s;
                        }
                        gVar.n(r3);
                    }
                }
                statisticItem.param("obj_type", 3);
            } else if (intValue == R.drawable.icon_mask_share_qqzone40_svg) {
                if (!j.z()) {
                    l.K(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    return;
                }
                if (z.b(this.f64163e, "com.tencent.mobileqq")) {
                    X("share_to_qzone", new Object[0]);
                    Y(4);
                    ShareItem r4 = r(4);
                    d0(r4, 5);
                    if (r4 != null) {
                        if (v(r4) && r4.a() != null && r4.a().contains(4)) {
                            d.b.i0.s.g.a.e(r4, this.f64163e, 4, this.n);
                        } else {
                            gVar.i(r4);
                        }
                    }
                } else {
                    Context context = this.f64163e;
                    BdToast.c(context, context.getText(R.string.share_qq_not_install)).q();
                }
                statisticItem.param("obj_type", 5);
            } else if (intValue == R.drawable.icon_qq_weibo) {
                if (!j.z()) {
                    l.K(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    return;
                }
                X("share_to_qweibo", new Object[0]);
                Y(5);
                ShareItem r5 = r(5);
                if (r5 != null) {
                    if (!r5.f13381a) {
                        r5.s = o(r5);
                    }
                    gVar.l(r5);
                }
            } else if (intValue == R.drawable.icon_mask_share_weibo40_svg) {
                if (!j.z()) {
                    l.K(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    return;
                }
                X("share_to_sweibo", new Object[0]);
                Y(6);
                ShareItem r6 = r(6);
                d0(r6, 7);
                if (r6 != null) {
                    if (!r6.f13381a) {
                        r6.s = o(r6);
                    }
                    if (v(r6) && r6.a() != null && r6.a().contains(4)) {
                        d.b.i0.s.g.a.e(r6, this.f64163e, 6, this.n);
                    } else {
                        gVar.k(r6);
                    }
                }
                statisticItem.param("obj_type", 6);
            } else if (intValue == R.drawable.icon_renren) {
                if (!j.z()) {
                    l.K(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    return;
                }
                X("share_to_renren", new Object[0]);
                Y(7);
                ShareItem r7 = r(7);
                if (r7 != null) {
                    if (!r7.f13381a) {
                        r7.s = o(r7);
                    }
                    gVar.j(r7);
                }
            } else if (intValue == R.drawable.icon_mask_share_qq40_svg) {
                if (!j.z()) {
                    l.K(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    return;
                }
                if (z.b(this.f64163e, "com.tencent.mobileqq")) {
                    X("share_to_qq_friend", new Object[0]);
                    Y(8);
                    ShareItem r8 = r(8);
                    d0(r8, 9);
                    if (r8 != null) {
                        if (v(r8) && r8.a() != null && r8.a().contains(4)) {
                            d.b.i0.s.g.a.e(r8, this.f64163e, 8, this.n);
                        } else {
                            gVar.h(r8);
                        }
                    }
                } else {
                    Context context2 = this.f64163e;
                    BdToast.c(context2, context2.getText(R.string.share_qq_not_install)).q();
                }
                statisticItem.param("obj_type", 4);
            } else if (intValue == R.drawable.icon_pure_share_download40) {
                if (this.q == null) {
                    this.q = new PermissionJudgePolicy();
                }
                this.q.clearRequestPermissionList();
                this.q.appendRequestPermission((Activity) this.f64163e, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                if (this.q.startRequestPermission((Activity) this.f64163e)) {
                    this.s = false;
                    return;
                }
                m();
                d0(r, 17);
                if (FileHelper.isLocalFile(r.v)) {
                    if (FileHelper.copyImageFile(FileHelper.getImageRealPathFromUri(this.f64163e, r.v), UUID.randomUUID().toString().replace("-", "").toLowerCase(), this.f64163e) == 0) {
                        l.L(this.f64163e, "保存成功！");
                    } else {
                        l.L(this.f64163e, "保存失败！");
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
                d0(r, 10);
                View.OnClickListener onClickListener = this.l;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                } else {
                    d.b.c.e.p.a.a(r.t);
                    l.L(this.f64163e.getApplicationContext(), this.f64163e.getResources().getString(R.string.copy_pb_url_success));
                }
                b0(r);
                if (r != null && r.f13381a) {
                    c0(8, r.B);
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
        if (PermissionUtil.checkLocationForGoogle(this.f64163e)) {
            LocationManager locationManager = (LocationManager) this.f64163e.getSystemService("location");
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

    public ShareItem r(int i) {
        ShareItem shareItem = this.r.get(i);
        return shareItem == null ? this.r.get(1) : shareItem;
    }

    public void s(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.m = onDismissListener;
        }
    }

    public LinearLayout u(int i, int i2) {
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.f64163e);
        shareDialogItemView.setItemIcon(i2, SkinManager.getColor(R.color.CAM_X0107));
        shareDialogItemView.setItemName(i);
        shareDialogItemView.a();
        return shareDialogItemView;
    }

    public final boolean v(ShareItem shareItem) {
        return (TextUtils.isEmpty(shareItem.k0) || TextUtils.isEmpty(shareItem.l0)) ? false : true;
    }

    public final boolean w(int i) {
        return (i & 8) > 0;
    }

    public final boolean x(int i) {
        return (i & 4) > 0;
    }

    public final boolean y(int i) {
        return (i & 1) > 0;
    }

    public final boolean z(int i) {
        return (i & 2) > 0;
    }

    public d(Context context) {
        this(context, false, 0);
    }
}
