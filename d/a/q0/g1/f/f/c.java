package d.a.q0.g1.f.f;

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
import d.a.d.e.m.d;
import d.a.q0.g1.c.p;
import java.util.List;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Animation f57078a;

    /* renamed from: b  reason: collision with root package name */
    public Animation f57079b;

    /* renamed from: c  reason: collision with root package name */
    public View f57080c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f57081d;

    /* renamed from: e  reason: collision with root package name */
    public View f57082e;

    /* renamed from: f  reason: collision with root package name */
    public InterfaceC1398c f57083f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.q0.g1.f.f.b f57084g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f57085h;

    /* renamed from: i  reason: collision with root package name */
    public int f57086i;

    /* loaded from: classes8.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f57087e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f57088f;

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
            this.f57088f = cVar;
            this.f57087e = context;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001433, this.f57088f.f57084g.getItem(i2)));
                this.f57088f.f(this.f57087e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f57089a;

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
            this.f57089a = cVar;
        }

        @Override // d.a.d.e.m.d, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f57089a.f57085h = false;
                if (this.f57089a.f57083f != null) {
                    this.f57089a.f57083f.a();
                }
                this.f57089a.f57081d.removeView(this.f57089a.f57080c);
            }
        }
    }

    /* renamed from: d.a.q0.g1.f.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC1398c {
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
        this.f57085h = false;
        this.f57081d = viewGroup;
    }

    public void f(Context context) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, context) == null) || (view = this.f57080c) == null) {
            return;
        }
        view.startAnimation(i(context));
    }

    public final View g(Context context, List<p> list, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, list, i2)) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.topic_scroll_fragment_more, (ViewGroup) null);
            this.f57082e = inflate.findViewById(R.id.topic_more_top_view);
            k(this.f57086i);
            GridView gridView = (GridView) inflate.findViewById(R.id.topic_scroll_fragment_more_content);
            gridView.setSelector(new ColorDrawable(17170445));
            d.a.q0.g1.f.f.b bVar = new d.a.q0.g1.f.f.b(context, i2);
            this.f57084g = bVar;
            bVar.b(list);
            gridView.setAdapter((ListAdapter) this.f57084g);
            gridView.setOnItemClickListener(new a(this, context));
            return inflate;
        }
        return (View) invokeLLI.objValue;
    }

    public final Animation h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            if (this.f57078a == null) {
                this.f57078a = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_enter);
            }
            return this.f57078a;
        }
        return (Animation) invokeL.objValue;
    }

    public final Animation i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            if (this.f57079b == null) {
                this.f57079b = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_exit);
            }
            this.f57079b.setAnimationListener(new b(this));
            return this.f57079b;
        }
        return (Animation) invokeL.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f57085h : invokeV.booleanValue;
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f57082e.getLayoutParams();
            layoutParams.height = i2;
            this.f57082e.setLayoutParams(layoutParams);
        }
    }

    public void l(InterfaceC1398c interfaceC1398c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC1398c) == null) {
            this.f57083f = interfaceC1398c;
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f57086i = i2;
        }
    }

    public void n(Context context, List<p> list, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, list, i2) == null) || this.f57085h) {
            return;
        }
        this.f57085h = true;
        View g2 = g(context, list, i2);
        this.f57080c = g2;
        this.f57081d.addView(g2);
        if (1 != TbadkCoreApplication.getInst().getSkinType() && 4 != TbadkCoreApplication.getInst().getSkinType()) {
            View view = this.f57080c;
            view.setBackgroundColor(view.getContext().getResources().getColor(R.color.topic_more_background));
        } else {
            View view2 = this.f57080c;
            view2.setBackgroundColor(view2.getContext().getResources().getColor(R.color.topic_more_background_1));
        }
        this.f57080c.startAnimation(h(context));
    }
}
