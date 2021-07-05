package d.a.s0.i1.f.j;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.chat.officialBar.MultiImageTextBottomView;
import com.baidu.tieba.im.chat.officialBar.MultiImageTextTopView;
import com.baidu.tieba.im.chat.officialBar.SingleImageTextView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.e.k.b<MultiImageTextTopView> f61555a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.c.e.k.b<MultiImageTextBottomView> f61556b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.c.e.k.b<SingleImageTextView> f61557c;

    /* loaded from: classes9.dex */
    public class a implements d.a.c.e.k.c<MultiImageTextTopView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f61558a;

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
            this.f61558a = context;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ MultiImageTextTopView a(MultiImageTextTopView multiImageTextTopView) {
            MultiImageTextTopView multiImageTextTopView2 = multiImageTextTopView;
            e(multiImageTextTopView2);
            return multiImageTextTopView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ MultiImageTextTopView c(MultiImageTextTopView multiImageTextTopView) {
            MultiImageTextTopView multiImageTextTopView2 = multiImageTextTopView;
            h(multiImageTextTopView2);
            return multiImageTextTopView2;
        }

        public MultiImageTextTopView e(MultiImageTextTopView multiImageTextTopView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, multiImageTextTopView)) == null) ? multiImageTextTopView : (MultiImageTextTopView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(MultiImageTextTopView multiImageTextTopView) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048581, this, multiImageTextTopView) == null) && (multiImageTextTopView instanceof MultiImageTextTopView)) {
                multiImageTextTopView.f();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public MultiImageTextTopView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new MultiImageTextTopView(this.f61558a) : (MultiImageTextTopView) invokeV.objValue;
        }

        public MultiImageTextTopView h(MultiImageTextTopView multiImageTextTopView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, multiImageTextTopView)) == null) {
                if (multiImageTextTopView instanceof MultiImageTextTopView) {
                    multiImageTextTopView.f();
                }
                return multiImageTextTopView;
            }
            return (MultiImageTextTopView) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b extends d.a.c.e.k.b<MultiImageTextTopView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c cVar, d.a.c.e.k.c cVar2, int i2, int i3) {
            super(cVar2, i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, cVar2, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((d.a.c.e.k.c) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* renamed from: d.a.s0.i1.f.j.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1502c implements d.a.c.e.k.c<MultiImageTextBottomView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f61559a;

        public C1502c(c cVar, Context context) {
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
            this.f61559a = context;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ MultiImageTextBottomView a(MultiImageTextBottomView multiImageTextBottomView) {
            MultiImageTextBottomView multiImageTextBottomView2 = multiImageTextBottomView;
            e(multiImageTextBottomView2);
            return multiImageTextBottomView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ MultiImageTextBottomView c(MultiImageTextBottomView multiImageTextBottomView) {
            MultiImageTextBottomView multiImageTextBottomView2 = multiImageTextBottomView;
            h(multiImageTextBottomView2);
            return multiImageTextBottomView2;
        }

        public MultiImageTextBottomView e(MultiImageTextBottomView multiImageTextBottomView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, multiImageTextBottomView)) == null) ? multiImageTextBottomView : (MultiImageTextBottomView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(MultiImageTextBottomView multiImageTextBottomView) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048581, this, multiImageTextBottomView) == null) && (multiImageTextBottomView instanceof MultiImageTextBottomView)) {
                multiImageTextBottomView.h();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public MultiImageTextBottomView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new MultiImageTextBottomView(this.f61559a) : (MultiImageTextBottomView) invokeV.objValue;
        }

        public MultiImageTextBottomView h(MultiImageTextBottomView multiImageTextBottomView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, multiImageTextBottomView)) == null) {
                if (multiImageTextBottomView instanceof MultiImageTextBottomView) {
                    multiImageTextBottomView.h();
                }
                return multiImageTextBottomView;
            }
            return (MultiImageTextBottomView) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class d extends d.a.c.e.k.b<MultiImageTextBottomView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(c cVar, d.a.c.e.k.c cVar2, int i2, int i3) {
            super(cVar2, i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, cVar2, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((d.a.c.e.k.c) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements d.a.c.e.k.c<SingleImageTextView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f61560a;

        public e(c cVar, Context context) {
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
            this.f61560a = context;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ SingleImageTextView a(SingleImageTextView singleImageTextView) {
            SingleImageTextView singleImageTextView2 = singleImageTextView;
            e(singleImageTextView2);
            return singleImageTextView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ SingleImageTextView c(SingleImageTextView singleImageTextView) {
            SingleImageTextView singleImageTextView2 = singleImageTextView;
            h(singleImageTextView2);
            return singleImageTextView2;
        }

        public SingleImageTextView e(SingleImageTextView singleImageTextView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, singleImageTextView)) == null) ? singleImageTextView : (SingleImageTextView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(SingleImageTextView singleImageTextView) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048581, this, singleImageTextView) == null) && (singleImageTextView instanceof SingleImageTextView)) {
                singleImageTextView.h();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public SingleImageTextView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new SingleImageTextView(this.f61560a) : (SingleImageTextView) invokeV.objValue;
        }

        public SingleImageTextView h(SingleImageTextView singleImageTextView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, singleImageTextView)) == null) {
                if (singleImageTextView instanceof SingleImageTextView) {
                    singleImageTextView.h();
                }
                return singleImageTextView;
            }
            return (SingleImageTextView) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1077463520, "Ld/a/s0/i1/f/j/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1077463520, "Ld/a/s0/i1/f/j/c;");
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.f61556b = new d(this, new C1502c(this, context), 9, 0);
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.f61557c = new d.a.c.e.k.b<>(new e(this, context), 1, 0);
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            this.f61555a = new b(this, new a(this, context), 1, 0);
        }
    }

    public d.a.c.e.k.b<MultiImageTextBottomView> d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            if (this.f61556b == null) {
                a(context);
            }
            return this.f61556b;
        }
        return (d.a.c.e.k.b) invokeL.objValue;
    }

    public d.a.c.e.k.b<SingleImageTextView> e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            if (this.f61557c == null) {
                b(context);
            }
            return this.f61557c;
        }
        return (d.a.c.e.k.b) invokeL.objValue;
    }

    public d.a.c.e.k.b<MultiImageTextTopView> f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            if (this.f61555a == null) {
                c(context);
            }
            return this.f61555a;
        }
        return (d.a.c.e.k.b) invokeL.objValue;
    }
}
