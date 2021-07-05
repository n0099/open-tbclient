package d.a.s0.g1.f.f;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.m.d;
import d.a.s0.g1.c.p;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Animation f59792a;

    /* renamed from: b  reason: collision with root package name */
    public Animation f59793b;

    /* renamed from: c  reason: collision with root package name */
    public View f59794c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f59795d;

    /* renamed from: e  reason: collision with root package name */
    public View f59796e;

    /* renamed from: f  reason: collision with root package name */
    public InterfaceC1435c f59797f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.s0.g1.f.f.b f59798g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f59799h;

    /* renamed from: i  reason: collision with root package name */
    public int f59800i;

    /* loaded from: classes9.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f59801e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f59802f;

        public a(c cVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59802f = cVar;
            this.f59801e = context;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001433, this.f59802f.f59798g.getItem(i2)));
                this.f59802f.f(this.f59801e);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f59803a;

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
            this.f59803a = cVar;
        }

        @Override // d.a.c.e.m.d, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f59803a.f59799h = false;
                if (this.f59803a.f59797f != null) {
                    this.f59803a.f59797f.a();
                }
                this.f59803a.f59795d.removeView(this.f59803a.f59794c);
            }
        }
    }

    /* renamed from: d.a.s0.g1.f.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC1435c {
        void a();
    }

    public c(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59799h = false;
        this.f59795d = viewGroup;
    }

    public void f(Context context) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, context) == null) || (view = this.f59794c) == null) {
            return;
        }
        view.startAnimation(i(context));
    }

    public final View g(Context context, List<p> list, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, list, i2)) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.topic_scroll_fragment_more, (ViewGroup) null);
            this.f59796e = inflate.findViewById(R.id.topic_more_top_view);
            k(this.f59800i);
            GridView gridView = (GridView) inflate.findViewById(R.id.topic_scroll_fragment_more_content);
            gridView.setSelector(new ColorDrawable(17170445));
            d.a.s0.g1.f.f.b bVar = new d.a.s0.g1.f.f.b(context, i2);
            this.f59798g = bVar;
            bVar.b(list);
            gridView.setAdapter((ListAdapter) this.f59798g);
            gridView.setOnItemClickListener(new a(this, context));
            return inflate;
        }
        return (View) invokeLLI.objValue;
    }

    public final Animation h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            if (this.f59792a == null) {
                this.f59792a = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_enter);
            }
            return this.f59792a;
        }
        return (Animation) invokeL.objValue;
    }

    public final Animation i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            if (this.f59793b == null) {
                this.f59793b = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_exit);
            }
            this.f59793b.setAnimationListener(new b(this));
            return this.f59793b;
        }
        return (Animation) invokeL.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f59799h : invokeV.booleanValue;
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f59796e.getLayoutParams();
            layoutParams.height = i2;
            this.f59796e.setLayoutParams(layoutParams);
        }
    }

    public void l(InterfaceC1435c interfaceC1435c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC1435c) == null) {
            this.f59797f = interfaceC1435c;
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f59800i = i2;
        }
    }

    public void n(Context context, List<p> list, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, list, i2) == null) || this.f59799h) {
            return;
        }
        this.f59799h = true;
        View g2 = g(context, list, i2);
        this.f59794c = g2;
        this.f59795d.addView(g2);
        if (1 != TbadkCoreApplication.getInst().getSkinType() && 4 != TbadkCoreApplication.getInst().getSkinType()) {
            View view = this.f59794c;
            view.setBackgroundColor(view.getContext().getResources().getColor(R.color.topic_more_background));
        } else {
            View view2 = this.f59794c;
            view2.setBackgroundColor(view2.getContext().getResources().getColor(R.color.topic_more_background_1));
        }
        this.f59794c.startAnimation(h(context));
    }
}
