package d.b.i0.t.j.g.d;

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
import d.b.c.e.p.l;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f62517a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f62518b;

    /* renamed from: c  reason: collision with root package name */
    public IImageFramePlayerViewController f62519c;

    /* renamed from: d  reason: collision with root package name */
    public AlaEffectPreviewView f62520d;

    /* renamed from: e  reason: collision with root package name */
    public AlaEnterEffectData f62521e;

    /* renamed from: f  reason: collision with root package name */
    public int f62522f = 2;

    /* renamed from: g  reason: collision with root package name */
    public IFrameCallback f62523g = new a();

    /* renamed from: h  reason: collision with root package name */
    public c f62524h = new C1629b();

    /* loaded from: classes4.dex */
    public class a implements IFrameCallback {
        public a() {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameEnd() {
            b.b(b.this);
            if (b.this.f62522f > 0 || b.this.f62521e == null) {
                return;
            }
            b bVar = b.this;
            bVar.g(bVar.f62521e);
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameStart() {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameUpdate(int i) {
        }
    }

    /* renamed from: d.b.i0.t.j.g.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1629b implements c {
        public C1629b() {
        }

        @Override // d.b.i0.t.j.g.d.b.c
        public void a() {
            b.b(b.this);
            if (b.this.f62521e != null) {
                if (b.this.f62521e.type != 1 || b.this.f62522f > 0) {
                    if (b.this.f62521e.type == 0) {
                        b bVar = b.this;
                        bVar.g(bVar.f62521e);
                        return;
                    }
                    return;
                }
                b bVar2 = b.this;
                bVar2.g(bVar2.f62521e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a();
    }

    public b(Context context, RelativeLayout relativeLayout) {
        this.f62517a = context;
        this.f62518b = relativeLayout;
    }

    public static /* synthetic */ int b(b bVar) {
        int i = bVar.f62522f;
        bVar.f62522f = i - 1;
        return i;
    }

    public void d() {
        IImageFramePlayerViewController iImageFramePlayerViewController = this.f62519c;
        if (iImageFramePlayerViewController != null) {
            iImageFramePlayerViewController.onDestroy();
        }
        AlaEffectPreviewView alaEffectPreviewView = this.f62520d;
        if (alaEffectPreviewView != null) {
            alaEffectPreviewView.f();
        }
    }

    public final void e(AlaEnterEffectData alaEnterEffectData) {
        AlaDynamicGiftConfigInfo alaDynamicGiftConfigInfo;
        CustomResponsedMessage runTask;
        if (this.f62519c == null && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER, IImageFramePlayerViewController.class, this.f62517a)) != null && runTask.getData() != null) {
            IImageFramePlayerViewController iImageFramePlayerViewController = (IImageFramePlayerViewController) runTask.getData();
            this.f62519c = iImageFramePlayerViewController;
            iImageFramePlayerViewController.setFrameCallback(this.f62523g);
        }
        IImageFramePlayerViewController iImageFramePlayerViewController2 = this.f62519c;
        if (iImageFramePlayerViewController2 != null) {
            if (iImageFramePlayerViewController2.getAnimView().getParent() == null) {
                this.f62518b.addView(this.f62519c.getAnimView(), new RelativeLayout.LayoutParams(-1, l.i(this.f62517a)));
            }
            AlaDynamicGiftAndNativeData alaDynamicGiftAndNativeData = new AlaDynamicGiftAndNativeData();
            AlaDynamicGift alaDynamicGift = alaEnterEffectData.gift;
            alaDynamicGiftAndNativeData.mAlaDynamicGift = alaDynamicGift;
            if (alaDynamicGift != null && (alaDynamicGiftConfigInfo = alaDynamicGift.configInfo) != null) {
                alaDynamicGiftConfigInfo.isBottomMargin = 1;
                alaDynamicGiftConfigInfo.oppositeY = 0.6499999761581421d;
            }
            alaDynamicGiftAndNativeData.upZipDirPath = AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName;
            this.f62519c.setData(alaDynamicGiftAndNativeData);
            this.f62519c.startAnim();
        }
    }

    public final void f(AlaEnterEffectData alaEnterEffectData) {
        if (this.f62520d == null) {
            AlaEffectPreviewView alaEffectPreviewView = new AlaEffectPreviewView(this.f62517a);
            this.f62520d = alaEffectPreviewView;
            alaEffectPreviewView.setAnimCompleteCallback(this.f62524h);
        }
        if (this.f62520d.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(2, R.id.effet_name_tv);
            layoutParams.bottomMargin = this.f62517a.getResources().getDimensionPixelSize(R.dimen.ds51);
            this.f62518b.addView(this.f62520d, layoutParams);
        }
        this.f62520d.setData(alaEnterEffectData);
        this.f62520d.g();
    }

    public void g(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData == null) {
            return;
        }
        this.f62521e = alaEnterEffectData;
        int i = alaEnterEffectData.type;
        if (i == 1) {
            this.f62522f = 2;
            e(alaEnterEffectData);
            f(alaEnterEffectData);
        } else if (i == 0) {
            f(alaEnterEffectData);
        }
    }
}
