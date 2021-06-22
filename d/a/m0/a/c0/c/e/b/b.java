package d.a.m0.a.c0.c.e.b;

import android.content.Context;
import android.graphics.drawable.Animatable;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
/* loaded from: classes2.dex */
public final class b extends d.a.m0.a.c0.a.b.a<SimpleDraweeView, c> {

    /* renamed from: i  reason: collision with root package name */
    public d.a.m0.a.c0.c.e.b.a f44645i;
    public SwanAppComponentContainerView j;
    public SimpleDraweeView k;

    /* loaded from: classes2.dex */
    public class a extends BaseControllerListener<ImageInfo> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f44646a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SimpleDraweeView f44647b;

        public a(boolean z, SimpleDraweeView simpleDraweeView) {
            this.f44646a = z;
            this.f44647b = simpleDraweeView;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFailure(String str, Throwable th) {
            super.onFailure(str, th);
            if (!this.f44646a || b.this.f44645i == null) {
                return;
            }
            b.this.f44645i.a(0, this.f44647b, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFinalImageSet(String str, ImageInfo imageInfo, Animatable animatable) {
            super.onFinalImageSet(str, (String) imageInfo, animatable);
            if (!this.f44646a || b.this.f44645i == null) {
                return;
            }
            b.this.f44645i.a(1, this.f44647b, null);
        }
    }

    public b(@NonNull Context context, @NonNull c cVar) {
        super(context, cVar);
        g(4);
        this.j = new SwanAppComponentContainerView(context);
        this.k = new SimpleDraweeView(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.a.c0.a.d.a, d.a.m0.a.c0.b.a
    @NonNull
    /* renamed from: a0 */
    public d.a.m0.a.c0.f.b k(@NonNull c cVar, @NonNull c cVar2) {
        d.a.m0.a.c0.f.b U = super.U(cVar, cVar2);
        if (cVar.y != cVar2.y) {
            U.b(9);
        }
        return U;
    }

    public final BaseControllerListener<ImageInfo> b0(@NonNull SimpleDraweeView simpleDraweeView, @NonNull c cVar) {
        return new a(cVar.y, simpleDraweeView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.a.c0.b.a
    @NonNull
    /* renamed from: c0 */
    public SimpleDraweeView v(@NonNull Context context) {
        return this.k;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.a.c0.b.a
    /* renamed from: d0 */
    public void B(@NonNull SimpleDraweeView simpleDraweeView) {
        super.B(simpleDraweeView);
        simpleDraweeView.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.a.c0.a.d.a
    /* renamed from: e0 */
    public void Q(@NonNull SimpleDraweeView simpleDraweeView, @NonNull c cVar, @NonNull d.a.m0.a.c0.f.b bVar) {
        super.V(simpleDraweeView, cVar, bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.a.c0.a.b.a
    /* renamed from: f0 */
    public void W(@NonNull SimpleDraweeView simpleDraweeView, @NonNull c cVar) {
        super.X(simpleDraweeView, cVar, b0(simpleDraweeView, cVar));
    }

    public void g0(d.a.m0.a.c0.c.e.b.a aVar) {
        this.f44645i = aVar;
    }

    @Override // d.a.m0.a.c0.b.a
    @NonNull
    public SwanAppComponentContainerView u(@NonNull Context context) {
        return this.j;
    }
}
