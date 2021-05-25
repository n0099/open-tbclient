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
    public Context f62153a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f62154b;

    /* renamed from: c  reason: collision with root package name */
    public IImageFramePlayerViewController f62155c;

    /* renamed from: d  reason: collision with root package name */
    public AlaEffectPreviewView f62156d;

    /* renamed from: e  reason: collision with root package name */
    public AlaEnterEffectData f62157e;

    /* renamed from: f  reason: collision with root package name */
    public int f62158f = 2;

    /* renamed from: g  reason: collision with root package name */
    public IFrameCallback f62159g = new a();

    /* renamed from: h  reason: collision with root package name */
    public c f62160h = new C1677b();

    /* loaded from: classes4.dex */
    public class a implements IFrameCallback {
        public a() {
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameEnd() {
            b.b(b.this);
            if (b.this.f62158f > 0 || b.this.f62157e == null) {
                return;
            }
            b bVar = b.this;
            bVar.g(bVar.f62157e);
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
    public class C1677b implements c {
        public C1677b() {
        }

        @Override // d.a.n0.v.j.g.d.b.c
        public void a() {
            b.b(b.this);
            if (b.this.f62157e != null) {
                if (b.this.f62157e.type != 1 || b.this.f62158f > 0) {
                    if (b.this.f62157e.type == 0) {
                        b bVar = b.this;
                        bVar.g(bVar.f62157e);
                        return;
                    }
                    return;
                }
                b bVar2 = b.this;
                bVar2.g(bVar2.f62157e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a();
    }

    public b(Context context, RelativeLayout relativeLayout) {
        this.f62153a = context;
        this.f62154b = relativeLayout;
    }

    public static /* synthetic */ int b(b bVar) {
        int i2 = bVar.f62158f;
        bVar.f62158f = i2 - 1;
        return i2;
    }

    public void d() {
        IImageFramePlayerViewController iImageFramePlayerViewController = this.f62155c;
        if (iImageFramePlayerViewController != null) {
            iImageFramePlayerViewController.onDestroy();
        }
        AlaEffectPreviewView alaEffectPreviewView = this.f62156d;
        if (alaEffectPreviewView != null) {
            alaEffectPreviewView.f();
        }
    }

    public final void e(AlaEnterEffectData alaEnterEffectData) {
        AlaDynamicGiftConfigInfo alaDynamicGiftConfigInfo;
        CustomResponsedMessage runTask;
        if (this.f62155c == null && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER, IImageFramePlayerViewController.class, this.f62153a)) != null && runTask.getData() != null) {
            IImageFramePlayerViewController iImageFramePlayerViewController = (IImageFramePlayerViewController) runTask.getData();
            this.f62155c = iImageFramePlayerViewController;
            iImageFramePlayerViewController.setFrameCallback(this.f62159g);
        }
        IImageFramePlayerViewController iImageFramePlayerViewController2 = this.f62155c;
        if (iImageFramePlayerViewController2 != null) {
            if (iImageFramePlayerViewController2.getAnimView().getParent() == null) {
                this.f62154b.addView(this.f62155c.getAnimView(), new RelativeLayout.LayoutParams(-1, l.i(this.f62153a)));
            }
            AlaDynamicGiftAndNativeData alaDynamicGiftAndNativeData = new AlaDynamicGiftAndNativeData();
            AlaDynamicGift alaDynamicGift = alaEnterEffectData.gift;
            alaDynamicGiftAndNativeData.mAlaDynamicGift = alaDynamicGift;
            if (alaDynamicGift != null && (alaDynamicGiftConfigInfo = alaDynamicGift.configInfo) != null) {
                alaDynamicGiftConfigInfo.isBottomMargin = 1;
                alaDynamicGiftConfigInfo.oppositeY = 0.6499999761581421d;
            }
            alaDynamicGiftAndNativeData.upZipDirPath = AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName;
            this.f62155c.setData(alaDynamicGiftAndNativeData);
            this.f62155c.startAnim();
        }
    }

    public final void f(AlaEnterEffectData alaEnterEffectData) {
        if (this.f62156d == null) {
            AlaEffectPreviewView alaEffectPreviewView = new AlaEffectPreviewView(this.f62153a);
            this.f62156d = alaEffectPreviewView;
            alaEffectPreviewView.setAnimCompleteCallback(this.f62160h);
        }
        if (this.f62156d.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(2, R.id.effet_name_tv);
            layoutParams.bottomMargin = this.f62153a.getResources().getDimensionPixelSize(R.dimen.ds51);
            this.f62154b.addView(this.f62156d, layoutParams);
        }
        this.f62156d.setData(alaEnterEffectData);
        this.f62156d.g();
    }

    public void g(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData == null) {
            return;
        }
        this.f62157e = alaEnterEffectData;
        int i2 = alaEnterEffectData.type;
        if (i2 == 1) {
            this.f62158f = 2;
            e(alaEnterEffectData);
            f(alaEnterEffectData);
        } else if (i2 == 0) {
            f(alaEnterEffectData);
        }
    }
}
