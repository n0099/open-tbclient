package com.kwad.sdk.entry;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsEntryElement;
import com.kwad.sdk.api.core.AbstractKsEntryElement;
import com.kwad.sdk.core.g.e;
import com.kwad.sdk.core.g.h;
import com.kwad.sdk.core.g.i;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.entry.view.EntryLinearView;
import com.kwad.sdk.entry.view.EntryTypeTabView;
import com.kwad.sdk.entry.view.b;
import com.kwad.sdk.entry.view.c;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class a extends AbstractKsEntryElement {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static com.kwad.sdk.entry.model.a f37227a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.response.model.a f37228b;

    /* renamed from: c  reason: collision with root package name */
    public c f37229c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37230d;

    /* renamed from: e  reason: collision with root package name */
    public h.a f37231e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicBoolean f37232f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-40444270, "Lcom/kwad/sdk/entry/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-40444270, "Lcom/kwad/sdk/entry/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f37230d = false;
        this.f37232f = new AtomicBoolean(false);
    }

    public static com.kwad.sdk.entry.model.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f37227a : (com.kwad.sdk.entry.model.a) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(Context context, KsEntryElement.OnFeedClickListener onFeedClickListener) {
        com.kwad.sdk.core.response.model.a aVar;
        c cVar;
        c cVar2;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65540, this, context, onFeedClickListener) != null) || this.f37229c != null || (aVar = this.f37228b) == null) {
            return;
        }
        int i3 = aVar.f36562a;
        if (i3 != 1) {
            if (i3 == 2) {
                i2 = R.layout.ksad_view_entry_viewpager;
            } else if (i3 == 3) {
                i2 = R.layout.ksad_view_entry_gifviewpager;
            } else if (i3 == 4) {
                i2 = R.layout.ksad_view_entryphoto4;
            } else if (i3 == 5) {
                c cVar3 = (c) View.inflate(context, R.layout.ksad_view_entry_tab, null);
                this.f37229c = cVar3;
                ((EntryTypeTabView) cVar3).setEnableSlideAutoOpen(this.f37230d);
                cVar2 = this.f37229c;
                if (cVar2 == null) {
                    if (!cVar2.a(this.f37228b)) {
                        this.f37229c = new b(context);
                    }
                    this.f37229c.setOnfeedClickListener(onFeedClickListener);
                    return;
                }
                return;
            } else {
                cVar = new b(context);
            }
            cVar = (c) View.inflate(context, i2, null);
        } else {
            cVar = (EntryLinearView) View.inflate(context, R.layout.ksad_view_entry_twophoto, null);
        }
        this.f37229c = cVar;
        cVar2 = this.f37229c;
        if (cVar2 == null) {
        }
    }

    public static void a(com.kwad.sdk.entry.model.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, aVar) == null) {
            f37227a = aVar;
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            f37227a = null;
        }
    }

    public void a(h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f37231e = aVar;
        }
    }

    public void a(com.kwad.sdk.core.response.model.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f37228b = aVar;
        }
    }

    @Override // com.kwad.sdk.api.core.AbstractKsEntryElement
    @Nullable
    public View getEntryView2(Context context, KsEntryElement.OnFeedClickListener onFeedClickListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, onFeedClickListener)) == null) {
            a(context, onFeedClickListener);
            return (View) this.f37229c;
        }
        return (View) invokeLL.objValue;
    }

    @Override // com.kwad.sdk.api.KsEntryElement
    public int getEntryViewType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            com.kwad.sdk.core.response.model.a aVar = this.f37228b;
            if (aVar != null) {
                return aVar.f36562a;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsEntryElement
    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f37231e == null || this.f37232f.get()) {
            return;
        }
        this.f37232f.set(true);
        i.a(this.f37231e, new e.a(this) { // from class: com.kwad.sdk.entry.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f37233a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f37233a = this;
            }

            @Override // com.kwad.sdk.core.g.e.a
            public void a(int i2, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                    this.f37233a.f37232f.set(false);
                }
            }

            @Override // com.kwad.sdk.core.g.e.a
            public void a(@NonNull AdResultData adResultData) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData) == null) {
                    this.f37233a.f37232f.set(false);
                    com.kwad.sdk.core.response.model.a aVar = adResultData.entryInfo;
                    if (aVar != null) {
                        this.f37233a.a(aVar);
                        if (this.f37233a.f37229c instanceof View) {
                            ((View) this.f37233a.f37229c).post(new Runnable(this) { // from class: com.kwad.sdk.entry.a.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass1 f37234a;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f37234a = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f37234a.f37233a.f37229c.a(this.f37234a.f37233a.f37228b);
                                    }
                                }
                            });
                        }
                    }
                }
            }
        });
    }

    @Override // com.kwad.sdk.api.KsEntryElement
    public void setEnableSlideAutoOpen(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f37230d = z;
            c cVar = this.f37229c;
            if (cVar instanceof EntryTypeTabView) {
                ((EntryTypeTabView) cVar).setEnableSlideAutoOpen(z);
            }
        }
    }

    @Override // com.kwad.sdk.api.KsEntryElement
    public void setTouchIntercept(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
        }
    }
}
