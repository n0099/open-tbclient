package d.a.n0.v.j.g.d;

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
    public Context f65868a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f65869b;

    /* renamed from: c  reason: collision with root package name */
    public IImageFramePlayerViewController f65870c;

    /* renamed from: d  reason: collision with root package name */
    public AlaEffectPreviewView f65871d;

    /* renamed from: e  reason: collision with root package name */
    public AlaEnterEffectData f65872e;

    /* renamed from: f  reason: collision with root package name */
    public int f65873f = 2;

    /* renamed from: g  reason: collision with root package name */
    public IFrameCallback f65874g = new a();

    /* renamed from: h  reason: collision with root package name */
    public c f65875h = new C1734b();

    /* loaded from: classes4.dex */
    public class a implements IFrameCallback {
        public a() {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameEnd() {
            b.b(b.this);
            if (b.this.f65873f > 0 || b.this.f65872e == null) {
                return;
            }
            b bVar = b.this;
            bVar.g(bVar.f65872e);
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameStart() {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameUpdate(int i2) {
        }
    }

    /* renamed from: d.a.n0.v.j.g.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1734b implements c {
        public C1734b() {
        }

        @Override // d.a.n0.v.j.g.d.b.c
        public void a() {
            b.b(b.this);
            if (b.this.f65872e != null) {
                if (b.this.f65872e.type != 1 || b.this.f65873f > 0) {
                    if (b.this.f65872e.type == 0) {
                        b bVar = b.this;
                        bVar.g(bVar.f65872e);
                        return;
                    }
                    return;
                }
                b bVar2 = b.this;
                bVar2.g(bVar2.f65872e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a();
    }

    public b(Context context, RelativeLayout relativeLayout) {
        this.f65868a = context;
        this.f65869b = relativeLayout;
    }

    public static /* synthetic */ int b(b bVar) {
        int i2 = bVar.f65873f;
        bVar.f65873f = i2 - 1;
        return i2;
    }

    public void d() {
        IImageFramePlayerViewController iImageFramePlayerViewController = this.f65870c;
        if (iImageFramePlayerViewController != null) {
            iImageFramePlayerViewController.onDestroy();
        }
        AlaEffectPreviewView alaEffectPreviewView = this.f65871d;
        if (alaEffectPreviewView != null) {
            alaEffectPreviewView.f();
        }
    }

    public final void e(AlaEnterEffectData alaEnterEffectData) {
        AlaDynamicGiftConfigInfo alaDynamicGiftConfigInfo;
        CustomResponsedMessage runTask;
        if (this.f65870c == null && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER, IImageFramePlayerViewController.class, this.f65868a)) != null && runTask.getData() != null) {
            IImageFramePlayerViewController iImageFramePlayerViewController = (IImageFramePlayerViewController) runTask.getData();
            this.f65870c = iImageFramePlayerViewController;
            iImageFramePlayerViewController.setFrameCallback(this.f65874g);
        }
        IImageFramePlayerViewController iImageFramePlayerViewController2 = this.f65870c;
        if (iImageFramePlayerViewController2 != null) {
            if (iImageFramePlayerViewController2.getAnimView().getParent() == null) {
                this.f65869b.addView(this.f65870c.getAnimView(), new RelativeLayout.LayoutParams(-1, l.i(this.f65868a)));
            }
            AlaDynamicGiftAndNativeData alaDynamicGiftAndNativeData = new AlaDynamicGiftAndNativeData();
            AlaDynamicGift alaDynamicGift = alaEnterEffectData.gift;
            alaDynamicGiftAndNativeData.mAlaDynamicGift = alaDynamicGift;
            if (alaDynamicGift != null && (alaDynamicGiftConfigInfo = alaDynamicGift.configInfo) != null) {
                alaDynamicGiftConfigInfo.isBottomMargin = 1;
                alaDynamicGiftConfigInfo.oppositeY = 0.6499999761581421d;
            }
            alaDynamicGiftAndNativeData.upZipDirPath = AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName;
            this.f65870c.setData(alaDynamicGiftAndNativeData);
            this.f65870c.startAnim();
        }
    }

    public final void f(AlaEnterEffectData alaEnterEffectData) {
        if (this.f65871d == null) {
            AlaEffectPreviewView alaEffectPreviewView = new AlaEffectPreviewView(this.f65868a);
            this.f65871d = alaEffectPreviewView;
            alaEffectPreviewView.setAnimCompleteCallback(this.f65875h);
        }
        if (this.f65871d.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(2, R.id.effet_name_tv);
            layoutParams.bottomMargin = this.f65868a.getResources().getDimensionPixelSize(R.dimen.ds51);
            this.f65869b.addView(this.f65871d, layoutParams);
        }
        this.f65871d.setData(alaEnterEffectData);
        this.f65871d.g();
    }

    public void g(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData == null) {
            return;
        }
        this.f65872e = alaEnterEffectData;
        int i2 = alaEnterEffectData.type;
        if (i2 == 1) {
            this.f65873f = 2;
            e(alaEnterEffectData);
            f(alaEnterEffectData);
        } else if (i2 == 0) {
            f(alaEnterEffectData);
        }
    }
}
