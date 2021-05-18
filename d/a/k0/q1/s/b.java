package d.a.k0.q1.s;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.searchbox.live.interfaces.service.tb.ShareChannelService;
import com.baidu.searchbox.live.interfaces.sharechennel.IShareCallback;
import com.baidu.searchbox.live.interfaces.sharechennel.IShareChannel;
import com.baidu.searchbox.live.interfaces.sharechennel.ShareEntity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import d.a.c.e.p.l;
import d.a.k0.d3.z;
import d.a.k0.m1.g;
/* loaded from: classes3.dex */
public class b implements ShareChannelService {

    /* loaded from: classes3.dex */
    public class a implements IShareChannel {
        public a() {
        }

        @Override // com.baidu.searchbox.live.interfaces.sharechennel.IShareChannel
        public void shareToChannel(ShareEntity shareEntity, int i2, IShareCallback iShareCallback) {
            if (i2 == 1) {
                b.this.c(6, shareEntity, iShareCallback);
            } else if (i2 == 3) {
                b.this.c(2, shareEntity, iShareCallback);
            } else if (i2 == 2) {
                b.this.c(3, shareEntity, iShareCallback);
            } else if (i2 == 4) {
                b.this.c(8, shareEntity, iShareCallback);
            }
        }
    }

    public final boolean b(int i2) {
        if (i2 == 2 || i2 == 3) {
            boolean b2 = z.b(TbadkCoreApplication.getInst(), "com.tencent.mm");
            if (b2) {
                return b2;
            }
            l.M(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(g.share_weixin_not_installed_yet));
            return b2;
        } else if (i2 == 6) {
            boolean b3 = z.b(TbadkCoreApplication.getInst(), "com.sina.weibo");
            if (b3) {
                return b3;
            }
            l.M(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(g.share_weibo_not_installed_yet));
            return b3;
        } else if (i2 != 8) {
            return false;
        } else {
            boolean b4 = z.b(TbadkCoreApplication.getInst(), "com.tencent.mobileqq");
            if (b4) {
                return b4;
            }
            l.M(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(g.share_qq_not_installed_yet));
            return b4;
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.tb.ShareChannelService
    public IShareChannel buildShareChannel() {
        return new a();
    }

    public final void c(int i2, ShareEntity shareEntity, IShareCallback iShareCallback) {
        if (shareEntity == null) {
            return;
        }
        if (!b(i2)) {
            if (iShareCallback != null) {
                iShareCallback.onShare(0, 0, "");
                return;
            }
            return;
        }
        ShareItem d2 = d(shareEntity);
        if (d2 == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaSDKShareEmptyActivityConfig(TbadkCoreApplication.getInst(), d2, i2, 2)));
    }

    public final ShareItem d(ShareEntity shareEntity) {
        if (shareEntity != null) {
            ShareItem shareItem = new ShareItem();
            shareItem.r = shareEntity.title;
            shareItem.s = shareEntity.content;
            shareItem.w = shareEntity.imageUrl;
            shareItem.t = shareEntity.linkUrl;
            shareItem.q = String.valueOf(shareEntity.liveId);
            shareItem.k0 = String.valueOf(shareEntity.userId);
            return shareItem;
        }
        return null;
    }
}
