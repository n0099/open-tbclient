package d.a.s0.v3.h.h;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.CoverPendantDragView;
import com.baidu.tieba.video.editvideo.view.CoverSeekBar;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.f;
import d.a.s0.v3.h.c.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c extends d.a.c.a.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f68718a;

    /* renamed from: b  reason: collision with root package name */
    public CoverSeekBar f68719b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f68720c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.s0.v3.h.h.a f68721d;

    /* renamed from: e  reason: collision with root package name */
    public HListView f68722e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.s0.v3.h.c.a f68723f;

    /* renamed from: g  reason: collision with root package name */
    public CoverPendantDragView f68724g;

    /* loaded from: classes9.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f68725a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68725a = cVar;
        }

        @Override // d.a.s0.v3.h.c.a.b
        public void a(View view, int i2, PendantData pendantData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, view, i2, pendantData) == null) {
                this.f68725a.f68724g.u(view, pendantData);
                StatisticItem statisticItem = new StatisticItem("c12305");
                statisticItem.param("obj_locate", i2 + 1);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements CoverSeekBar.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f68726a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68726a = cVar;
        }

        @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TiebaStatic.log("c12304");
            }
        }

        @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.baidu.tieba.video.editvideo.view.CoverSeekBar.d
        public void onProgress(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                int duration = (int) ((this.f68726a.f68721d.x().getDuration() * i2) / 1000);
                this.f68726a.f68719b.setProgressImage(i2, duration);
                this.f68726a.f68721d.x().seekTo(duration);
            }
        }
    }

    /* renamed from: d.a.s0.v3.h.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1854c extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f68727e;

        public C1854c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68727e = cVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                this.f68727e.f68720c.animate().alphaBy(1.0f).alpha(0.0f).setDuration(500L).setStartDelay(2000L).start();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f68728e;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68728e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f68728e.f68719b.k(this.f68728e.f68719b.getCurrentPosition());
                this.f68728e.f68721d.G();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(f fVar, d.a.s0.v3.h.h.a aVar) {
        super(fVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68721d = aVar;
        View inflate = LayoutInflater.from(fVar.getPageActivity()).inflate(R.layout.edit_cover_layout, (ViewGroup) null);
        this.f68718a = inflate;
        inflate.getResources();
        o();
    }

    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f68719b.getCurrentPosition() : invokeV.intValue;
    }

    public Bitmap h(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap)) == null) {
            this.f68724g.A();
            String text = this.f68724g.getText();
            if (bitmap == null || TextUtils.isEmpty(text)) {
                return null;
            }
            int width = this.f68721d.x().getWidth();
            int height = this.f68721d.x().getHeight();
            int width2 = bitmap.getWidth();
            int height2 = bitmap.getHeight();
            Bitmap createBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            Bitmap tempBitmap = this.f68724g.getTempBitmap();
            if (tempBitmap != null) {
                Matrix matrix = new Matrix();
                matrix.postScale(width2 / width, height2 / height);
                Bitmap createBitmap2 = Bitmap.createBitmap(tempBitmap, this.f68721d.x().getLeft(), this.f68721d.x().getTop(), width, height, matrix, true);
                if (createBitmap2 != null) {
                    canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
                }
            }
            canvas.save();
            canvas.restore();
            return createBitmap;
        }
        return (Bitmap) invokeL.objValue;
    }

    public final List<PendantData> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(0, new PendantData(0));
            arrayList.add(1, new PendantData(1));
            arrayList.add(2, new PendantData(2));
            arrayList.add(3, new PendantData(3));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f68718a : (View) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f68724g.getText() : (String) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f68724g.A();
        }
    }

    public void n(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            CoverPendantDragView coverPendantDragView = (CoverPendantDragView) view.findViewById(R.id.cover_pendant_view);
            this.f68724g = coverPendantDragView;
            coverPendantDragView.setParentViewController(this);
            this.f68720c = (LinearLayout) view.findViewById(R.id.cover_tips);
            if (d.a.r0.r.d0.b.j().g("video_cover_first_in", true)) {
                this.f68720c.setVisibility(0);
                this.f68720c.animate().alphaBy(0.0f).alpha(1.0f).setDuration(500L).setListener(new C1854c(this)).start();
                d.a.r0.r.d0.b.j().t("video_cover_first_in", false);
            }
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f68719b = (CoverSeekBar) this.f68718a.findViewById(R.id.cover_seek_bar);
            this.f68722e = (HListView) this.f68718a.findViewById(R.id.pendant_list_view);
            d.a.s0.v3.h.c.a aVar = new d.a.s0.v3.h.c.a(getPageContext());
            this.f68723f = aVar;
            aVar.d(new a(this));
            this.f68722e.setAdapter((ListAdapter) this.f68723f);
            this.f68723f.c(i());
            this.f68719b.setOnProgressChanged(new b(this));
        }
    }

    public void p(f fVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar, i2) == null) {
            SkinManager.setBackgroundColor(this.f68718a, R.color.CAM_X0201);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            d.a.c.e.m.e.a().postDelayed(new d(this), 500L);
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f68724g.K(z);
            if (z) {
                CoverSeekBar coverSeekBar = this.f68719b;
                coverSeekBar.k(coverSeekBar.getCurrentPosition());
            }
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            CoverSeekBar coverSeekBar = this.f68719b;
            if (coverSeekBar != null) {
                coverSeekBar.j();
            }
            CoverPendantDragView coverPendantDragView = this.f68724g;
            if (coverPendantDragView != null) {
                coverPendantDragView.I();
            }
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f68724g.setVideoSize(this.f68721d.x().getWidth(), this.f68721d.x().getHeight());
            this.f68724g.setVideoLocation(this.f68721d.x().getLeft(), this.f68721d.x().getTop(), this.f68721d.x().getRight(), this.f68721d.x().getBottom());
        }
    }

    public void v(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f68719b.setData(str);
    }

    public void w(List<PendantData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            list.addAll(0, i());
            this.f68723f.c(list);
        }
    }
}
