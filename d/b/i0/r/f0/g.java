package d.b.i0.r.f0;

import android.graphics.drawable.AnimationDrawable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PullViewHelper;
/* loaded from: classes3.dex */
public class g extends f {
    public boolean E;
    public boolean F;
    public boolean G;
    public CustomMessageListener H;
    public CustomMessageListener I;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            g gVar = g.this;
            if (gVar.F) {
                gVar.I(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            g.this.l.setBackgroundColor(PullViewHelper.getInstance().getPullViewBackgroundColor(TbadkCoreApplication.getInst().getSkinType()));
        }
    }

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.F = true;
        this.G = false;
        this.H = new a(2016203);
        this.I = new b(2016204);
        W(tbPageContext);
    }

    @Override // d.b.i0.r.f0.f
    public void I(int i) {
        super.I(i);
        if (this.l == null || this.m == null) {
            return;
        }
        this.E = false;
        if (!L()) {
            AnimationDrawable animationDrawable = PullViewHelper.getInstance().getAnimationDrawable(i);
            this.r = animationDrawable;
            if (animationDrawable != null) {
                this.E = true;
            } else {
                this.r = new AnimationDrawable();
            }
            if (!this.E) {
                this.r = PullViewHelper.getInstance().getDefaultAnimationDrawable(i);
            }
            this.r.setOneShot(false);
            this.m.setBackgroundDrawable(this.r);
        }
        if (this.G) {
            this.l.setBackgroundColor(0);
        }
    }

    public final void W(TbPageContext<?> tbPageContext) {
        this.H.setTag(tbPageContext.getUniqueId());
        this.I.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.H);
        tbPageContext.registerListener(this.I);
    }

    public void X() {
        MessageManager.getInstance().unRegisterListener(this.H);
        MessageManager.getInstance().unRegisterListener(this.I);
    }

    public void Y(boolean z) {
        this.G = z;
    }

    public void Z(BdUniqueId bdUniqueId) {
        CustomMessageListener customMessageListener = this.H;
        if (customMessageListener != null) {
            customMessageListener.setTag(bdUniqueId);
        }
        CustomMessageListener customMessageListener2 = this.I;
        if (customMessageListener2 != null) {
            customMessageListener2.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.H);
        MessageManager.getInstance().registerListener(this.I);
    }

    @Override // d.b.i0.r.f0.f, d.b.c.j.e.c
    public void o(boolean z) {
        this.m.setBackgroundDrawable(null);
        super.o(z);
        this.F = true;
    }

    @Override // d.b.i0.r.f0.f, d.b.c.j.e.c
    public void x(boolean z) {
        super.x(z);
        this.F = false;
        if (this.E) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        int i = this.t;
        if (i != Integer.MIN_VALUE) {
            skinType = i;
        }
        I(skinType);
    }

    @Override // d.b.i0.r.f0.f, d.b.c.j.e.c
    public void y() {
        super.y();
        this.F = false;
    }
}
