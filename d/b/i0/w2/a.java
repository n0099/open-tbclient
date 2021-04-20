package d.b.i0.w2;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import d.b.c.e.p.j;
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import d.b.h0.s.g.g;
import d.b.i0.d3.z;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f63712a;

    public a(Context context) {
        this.f63712a = context;
    }

    public final String a(ShareItem shareItem) {
        String str = "【" + shareItem.r + "】 " + shareItem.s;
        shareItem.s = str;
        return str;
    }

    public final Location b() {
        if (PermissionUtil.checkLocationForGoogle(this.f63712a)) {
            LocationManager locationManager = (LocationManager) this.f63712a.getSystemService("location");
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

    public void c(int i, ShareItem shareItem, boolean z) {
        Location b2;
        if (shareItem == null) {
            return;
        }
        if (!j.z()) {
            l.K(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
            return;
        }
        if (z && (b2 = b()) != null) {
            shareItem.A = b2;
        }
        g gVar = new g(this.f63712a, null);
        if (i == 3) {
            IWXAPI createWXAPI = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID);
            if (createWXAPI != null && !createWXAPI.isWXAppInstalled()) {
                BdToast.c(this.f63712a, TbadkCoreApplication.getInst().getText(R.string.share_weixin_not_installed_yet)).q();
                return;
            }
            e(shareItem, 4);
            gVar.m(shareItem);
        } else if (i == 2) {
            IWXAPI createWXAPI2 = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID);
            if (createWXAPI2 != null && !createWXAPI2.isWXAppInstalled()) {
                BdToast.c(this.f63712a, TbadkCoreApplication.getInst().getText(R.string.share_weixin_not_installed_yet)).q();
                return;
            }
            e(shareItem, 3);
            if (shareItem.f13374b) {
                shareItem.s = a(shareItem);
            }
            gVar.n(shareItem);
        } else if (i == 4) {
            if (z.b(this.f63712a, "com.tencent.mobileqq")) {
                e(shareItem, 5);
                gVar.i(shareItem);
                return;
            }
            Context context = this.f63712a;
            BdToast.c(context, context.getText(R.string.share_qq_not_install)).q();
        } else if (i == 5) {
            if (!shareItem.f13373a) {
                shareItem.s = a(shareItem);
            }
            gVar.l(shareItem);
        } else if (i == 6) {
            e(shareItem, 7);
            if (!shareItem.f13373a) {
                shareItem.s = a(shareItem);
            }
            gVar.k(shareItem);
        } else if (i == 7) {
            if (!shareItem.f13373a) {
                shareItem.s = a(shareItem);
            }
            gVar.j(shareItem);
        } else if (i == 8) {
            if (z.b(this.f63712a, "com.tencent.mobileqq")) {
                e(shareItem, 9);
                gVar.h(shareItem);
                return;
            }
            Context context2 = this.f63712a;
            BdToast.c(context2, context2.getText(R.string.share_qq_not_install)).q();
        }
    }

    public final void d(int i, String str) {
        TiebaStatic.eventStat(this.f63712a, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    public final void e(ShareItem shareItem, int i) {
        if (shareItem == null || shareItem.q == null) {
            return;
        }
        if (shareItem.f13374b) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", shareItem.q).param("obj_type", i));
        } else if (!shareItem.f13375c && !shareItem.f13378f) {
            if (shareItem.f13376d) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).param("tid", shareItem.q).param("obj_type", i));
            } else if (shareItem.f13373a) {
                d(i, shareItem.B);
            } else if (shareItem.f13377e) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", 7).param("obj_type", i).param("fid", shareItem.q));
            } else if (shareItem.f13379g) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i);
                param.param("obj_source", shareItem.D);
                if (!k.isEmpty(shareItem.t) && shareItem.t.contains("worldcup")) {
                    param.param("obj_param1", 9);
                }
                TiebaStatic.log(param);
            } else if (shareItem.f13380h) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("tid", shareItem.q).param("fid", shareItem.I).param("obj_type", i).param("obj_source", shareItem.D).param("obj_param1", shareItem.E).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.F).param(TiebaStatic.Params.OBJ_PARAM3, shareItem.G).param("obj_locate", shareItem.H));
            }
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("tid", shareItem.q).param("obj_type", i).param("obj_source", shareItem.D).param("obj_param1", shareItem.E).param("fid", shareItem.I).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.F));
        }
    }
}
