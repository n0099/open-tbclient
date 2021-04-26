package d.a.j0.t.j.g.d;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.gift.AlaDynamicGift;
import com.baidu.ala.gift.AlaDynamicGiftAndNativeData;
import com.baidu.ala.gift.AlaDynamicGiftConfigInfo;
import com.baidu.ala.gift.AlaDynamicGiftLocalInfoConfig;
import com.baidu.ala.gift.IFrameCallback;
import com.baidu.ala.gift.IImageFramePlayerViewController;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEffectPreviewView;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f61141a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f61142b;

    /* renamed from: c  reason: collision with root package name */
    public IImageFramePlayerViewController f61143c;

    /* renamed from: d  reason: collision with root package name */
    public AlaEffectPreviewView f61144d;

    /* renamed from: e  reason: collision with root package name */
    public AlaEnterEffectData f61145e;

    /* renamed from: f  reason: collision with root package name */
    public int f61146f = 2;

    /* renamed from: g  reason: collision with root package name */
    public IFrameCallback f61147g = new a();

    /* renamed from: h  reason: collision with root package name */
    public c f61148h = new C1592b();

    /* loaded from: classes4.dex */
    public class a implements IFrameCallback {
        public a() {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameEnd() {
            b.b(b.this);
            if (b.this.f61146f > 0 || b.this.f61145e == null) {
                return;
            }
            b bVar = b.this;
            bVar.g(bVar.f61145e);
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameStart() {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameUpdate(int i2) {
        }
    }

    /* renamed from: d.a.j0.t.j.g.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1592b implements c {
        public C1592b() {
        }

        @Override // d.a.j0.t.j.g.d.b.c
        public void a() {
            b.b(b.this);
            if (b.this.f61145e != null) {
                if (b.this.f61145e.type != 1 || b.this.f61146f > 0) {
                    if (b.this.f61145e.type == 0) {
                        b bVar = b.this;
                        bVar.g(bVar.f61145e);
                        return;
                    }
                    return;
                }
                b bVar2 = b.this;
                bVar2.g(bVar2.f61145e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a();
    }

    public b(Context context, RelativeLayout relativeLayout) {
        this.f61141a = context;
        this.f61142b = relativeLayout;
    }

    public static /* synthetic */ int b(b bVar) {
        int i2 = bVar.f61146f;
        bVar.f61146f = i2 - 1;
        return i2;
    }

    public void d() {
        IImageFramePlayerViewController iImageFramePlayerViewController = this.f61143c;
        if (iImageFramePlayerViewController != null) {
            iImageFramePlayerViewController.onDestroy();
        }
        AlaEffectPreviewView alaEffectPreviewView = this.f61144d;
        if (alaEffectPreviewView != null) {
            alaEffectPreviewView.f();
        }
    }

    public final void e(AlaEnterEffectData alaEnterEffectData) {
        AlaDynamicGiftConfigInfo alaDynamicGiftConfigInfo;
        CustomResponsedMessage runTask;
        if (this.f61143c == null && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER, IImageFramePlayerViewController.class, this.f61141a)) != null && runTask.getData() != null) {
            IImageFramePlayerViewController iImageFramePlayerViewController = (IImageFramePlayerViewController) runTask.getData();
            this.f61143c = iImageFramePlayerViewController;
            iImageFramePlayerViewController.setFrameCallback(this.f61147g);
        }
        IImageFramePlayerViewController iImageFramePlayerViewController2 = this.f61143c;
        if (iImageFramePlayerViewController2 != null) {
            if (iImageFramePlayerViewController2.getAnimView().getParent() == null) {
                this.f61142b.addView(this.f61143c.getAnimView(), new RelativeLayout.LayoutParams(-1, l.i(this.f61141a)));
            }
            AlaDynamicGiftAndNativeData alaDynamicGiftAndNativeData = new AlaDynamicGiftAndNativeData();
            AlaDynamicGift alaDynamicGift = alaEnterEffectData.gift;
            alaDynamicGiftAndNativeData.mAlaDynamicGift = alaDynamicGift;
            if (alaDynamicGift != null && (alaDynamicGiftConfigInfo = alaDynamicGift.configInfo) != null) {
                alaDynamicGiftConfigInfo.isBottomMargin = 1;
                alaDynamicGiftConfigInfo.oppositeY = 0.6499999761581421d;
            }
            alaDynamicGiftAndNativeData.upZipDirPath = AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName;
            this.f61143c.setData(alaDynamicGiftAndNativeData);
            this.f61143c.startAnim();
        }
    }

    public final void f(AlaEnterEffectData alaEnterEffectData) {
        if (this.f61144d == null) {
            AlaEffectPreviewView alaEffectPreviewView = new AlaEffectPreviewView(this.f61141a);
            this.f61144d = alaEffectPreviewView;
            alaEffectPreviewView.setAnimCompleteCallback(this.f61148h);
        }
        if (this.f61144d.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(2, R.id.effet_name_tv);
            layoutParams.bottomMargin = this.f61141a.getResources().getDimensionPixelSize(R.dimen.ds51);
            this.f61142b.addView(this.f61144d, layoutParams);
        }
        this.f61144d.setData(alaEnterEffectData);
        this.f61144d.g();
    }

    public void g(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData == null) {
            return;
        }
        this.f61145e = alaEnterEffectData;
        int i2 = alaEnterEffectData.type;
        if (i2 == 1) {
            this.f61146f = 2;
            e(alaEnterEffectData);
            f(alaEnterEffectData);
        } else if (i2 == 0) {
            f(alaEnterEffectData);
        }
    }
}
