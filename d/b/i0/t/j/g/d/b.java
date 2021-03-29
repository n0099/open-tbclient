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
import d.b.b.e.p.l;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f60953a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f60954b;

    /* renamed from: c  reason: collision with root package name */
    public IImageFramePlayerViewController f60955c;

    /* renamed from: d  reason: collision with root package name */
    public AlaEffectPreviewView f60956d;

    /* renamed from: e  reason: collision with root package name */
    public AlaEnterEffectData f60957e;

    /* renamed from: f  reason: collision with root package name */
    public int f60958f = 2;

    /* renamed from: g  reason: collision with root package name */
    public IFrameCallback f60959g = new a();

    /* renamed from: h  reason: collision with root package name */
    public c f60960h = new C1576b();

    /* loaded from: classes4.dex */
    public class a implements IFrameCallback {
        public a() {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameEnd() {
            b.b(b.this);
            if (b.this.f60958f > 0 || b.this.f60957e == null) {
                return;
            }
            b bVar = b.this;
            bVar.g(bVar.f60957e);
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
    public class C1576b implements c {
        public C1576b() {
        }

        @Override // d.b.i0.t.j.g.d.b.c
        public void a() {
            b.b(b.this);
            if (b.this.f60957e != null) {
                if (b.this.f60957e.type != 1 || b.this.f60958f > 0) {
                    if (b.this.f60957e.type == 0) {
                        b bVar = b.this;
                        bVar.g(bVar.f60957e);
                        return;
                    }
                    return;
                }
                b bVar2 = b.this;
                bVar2.g(bVar2.f60957e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a();
    }

    public b(Context context, RelativeLayout relativeLayout) {
        this.f60953a = context;
        this.f60954b = relativeLayout;
    }

    public static /* synthetic */ int b(b bVar) {
        int i = bVar.f60958f;
        bVar.f60958f = i - 1;
        return i;
    }

    public void d() {
        IImageFramePlayerViewController iImageFramePlayerViewController = this.f60955c;
        if (iImageFramePlayerViewController != null) {
            iImageFramePlayerViewController.onDestroy();
        }
        AlaEffectPreviewView alaEffectPreviewView = this.f60956d;
        if (alaEffectPreviewView != null) {
            alaEffectPreviewView.f();
        }
    }

    public final void e(AlaEnterEffectData alaEnterEffectData) {
        AlaDynamicGiftConfigInfo alaDynamicGiftConfigInfo;
        CustomResponsedMessage runTask;
        if (this.f60955c == null && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER, IImageFramePlayerViewController.class, this.f60953a)) != null && runTask.getData() != null) {
            IImageFramePlayerViewController iImageFramePlayerViewController = (IImageFramePlayerViewController) runTask.getData();
            this.f60955c = iImageFramePlayerViewController;
            iImageFramePlayerViewController.setFrameCallback(this.f60959g);
        }
        IImageFramePlayerViewController iImageFramePlayerViewController2 = this.f60955c;
        if (iImageFramePlayerViewController2 != null) {
            if (iImageFramePlayerViewController2.getAnimView().getParent() == null) {
                this.f60954b.addView(this.f60955c.getAnimView(), new RelativeLayout.LayoutParams(-1, l.i(this.f60953a)));
            }
            AlaDynamicGiftAndNativeData alaDynamicGiftAndNativeData = new AlaDynamicGiftAndNativeData();
            AlaDynamicGift alaDynamicGift = alaEnterEffectData.gift;
            alaDynamicGiftAndNativeData.mAlaDynamicGift = alaDynamicGift;
            if (alaDynamicGift != null && (alaDynamicGiftConfigInfo = alaDynamicGift.configInfo) != null) {
                alaDynamicGiftConfigInfo.isBottomMargin = 1;
                alaDynamicGiftConfigInfo.oppositeY = 0.6499999761581421d;
            }
            alaDynamicGiftAndNativeData.upZipDirPath = AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName;
            this.f60955c.setData(alaDynamicGiftAndNativeData);
            this.f60955c.startAnim();
        }
    }

    public final void f(AlaEnterEffectData alaEnterEffectData) {
        if (this.f60956d == null) {
            AlaEffectPreviewView alaEffectPreviewView = new AlaEffectPreviewView(this.f60953a);
            this.f60956d = alaEffectPreviewView;
            alaEffectPreviewView.setAnimCompleteCallback(this.f60960h);
        }
        if (this.f60956d.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(2, R.id.effet_name_tv);
            layoutParams.bottomMargin = this.f60953a.getResources().getDimensionPixelSize(R.dimen.ds51);
            this.f60954b.addView(this.f60956d, layoutParams);
        }
        this.f60956d.setData(alaEnterEffectData);
        this.f60956d.g();
    }

    public void g(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData == null) {
            return;
        }
        this.f60957e = alaEnterEffectData;
        int i = alaEnterEffectData.type;
        if (i == 1) {
            this.f60958f = 2;
            e(alaEnterEffectData);
            f(alaEnterEffectData);
        } else if (i == 0) {
            f(alaEnterEffectData);
        }
    }
}
