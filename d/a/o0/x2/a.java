package d.a.o0.x2;

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
import d.a.c.e.p.j;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.n0.s.g.g;
import d.a.o0.e3.z;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f67137a;

    public a(Context context) {
        this.f67137a = context;
    }

    public final String a(ShareItem shareItem) {
        String str = "【" + shareItem.r + "】 " + shareItem.s;
        shareItem.s = str;
        return str;
    }

    public final Location b() {
        if (PermissionUtil.checkLocationForGoogle(this.f67137a)) {
            LocationManager locationManager = (LocationManager) this.f67137a.getSystemService("location");
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

    public void c(int i2, ShareItem shareItem, boolean z) {
        Location b2;
        if (shareItem == null) {
            return;
        }
        if (!j.z()) {
            l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
            return;
        }
        if (z && (b2 = b()) != null) {
            shareItem.B = b2;
        }
        g gVar = new g(this.f67137a, null);
        if (i2 == 3) {
            IWXAPI createWXAPI = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID);
            if (createWXAPI != null && !createWXAPI.isWXAppInstalled()) {
                BdToast.c(this.f67137a, TbadkCoreApplication.getInst().getText(R.string.share_weixin_not_installed_yet)).q();
                return;
            }
            e(shareItem, 4);
            gVar.m(shareItem);
        } else if (i2 == 2) {
            IWXAPI createWXAPI2 = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID);
            if (createWXAPI2 != null && !createWXAPI2.isWXAppInstalled()) {
                BdToast.c(this.f67137a, TbadkCoreApplication.getInst().getText(R.string.share_weixin_not_installed_yet)).q();
                return;
            }
            e(shareItem, 3);
            if (shareItem.f12740b) {
                shareItem.s = a(shareItem);
            }
            gVar.n(shareItem);
        } else if (i2 == 4) {
            if (z.b(this.f67137a, "com.tencent.mobileqq")) {
                e(shareItem, 5);
                gVar.i(shareItem);
                return;
            }
            Context context = this.f67137a;
            BdToast.c(context, context.getText(R.string.share_qq_not_install)).q();
        } else if (i2 == 5) {
            if (!shareItem.f12739a) {
                shareItem.s = a(shareItem);
            }
            gVar.l(shareItem);
        } else if (i2 == 6) {
            e(shareItem, 7);
            if (!shareItem.f12739a) {
                shareItem.s = a(shareItem);
            }
            gVar.k(shareItem);
        } else if (i2 == 7) {
            if (!shareItem.f12739a) {
                shareItem.s = a(shareItem);
            }
            gVar.j(shareItem);
        } else if (i2 == 8) {
            if (z.b(this.f67137a, "com.tencent.mobileqq")) {
                e(shareItem, 9);
                gVar.h(shareItem);
                return;
            }
            Context context2 = this.f67137a;
            BdToast.c(context2, context2.getText(R.string.share_qq_not_install)).q();
        }
    }

    public final void d(int i2, String str) {
        TiebaStatic.eventStat(this.f67137a, "pb_new_share", null, 1, "loc", Integer.valueOf(i2), PbChosenActivityConfig.KEY_TID, str);
    }

    public final void e(ShareItem shareItem, int i2) {
        if (shareItem == null || shareItem.q == null) {
            return;
        }
        if (shareItem.f12740b) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", shareItem.q).param("obj_type", i2));
        } else if (!shareItem.f12741c && !shareItem.f12744f) {
            if (shareItem.f12742d) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).param("tid", shareItem.q).param("obj_type", i2));
            } else if (shareItem.f12739a) {
                d(i2, shareItem.C);
            } else if (shareItem.f12743e) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", 7).param("obj_type", i2).param("fid", shareItem.q));
            } else if (shareItem.f12745g) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i2);
                param.param("obj_source", shareItem.E);
                if (!k.isEmpty(shareItem.t) && shareItem.t.contains("worldcup")) {
                    param.param("obj_param1", 9);
                }
                TiebaStatic.log(param);
            } else if (shareItem.f12746h) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("tid", shareItem.q).param("fid", shareItem.J).param("obj_type", i2).param("obj_source", shareItem.E).param("obj_param1", shareItem.F).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.G).param(TiebaStatic.Params.OBJ_PARAM3, shareItem.H).param("obj_locate", shareItem.I));
            }
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("tid", shareItem.q).param("obj_type", i2).param("obj_source", shareItem.E).param("obj_param1", shareItem.F).param("fid", shareItem.J).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.G));
        }
    }
}
