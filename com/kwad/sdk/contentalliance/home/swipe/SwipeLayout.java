package com.kwad.sdk.contentalliance.home.swipe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class SwipeLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f35249a;

    /* renamed from: b  reason: collision with root package name */
    public float f35250b;

    /* renamed from: c  reason: collision with root package name */
    public float f35251c;

    /* renamed from: d  reason: collision with root package name */
    public int f35252d;

    /* renamed from: e  reason: collision with root package name */
    public d f35253e;

    /* renamed from: f  reason: collision with root package name */
    public List<a> f35254f;

    /* loaded from: classes7.dex */
    public interface a {
        void a();

        void b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeLayout(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35252d = 0;
        this.f35254f = new ArrayList();
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f35252d = 0;
        this.f35254f = new ArrayList();
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f35252d = 0;
        this.f35254f = new ArrayList();
        a(context);
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, context) == null) {
            this.f35249a = ViewConfiguration.get(context).getScaledPagingTouchSlop();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0088 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(MotionEvent motionEvent) {
        InterceptResult invokeL;
        StringBuilder sb;
        float f2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65540, this, motionEvent)) != null) {
            return invokeL.booleanValue;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f35250b = motionEvent.getX();
            this.f35251c = motionEvent.getY();
            this.f35252d = 0;
            sb = new StringBuilder();
            sb.append("onInterceptTouchEvent ACTION_DOWN mInitialMotionX=");
            f2 = this.f35250b;
        } else if (action == 1) {
            this.f35252d = 0;
            str = "onInterceptTouchEvent ACTION_UP";
            com.kwad.sdk.core.d.a.a("SwipeLayout", str);
            if (this.f35252d != 0) {
            }
        } else if (action != 2) {
            if (action == 3) {
                this.f35252d = 0;
            }
            return this.f35252d != 0;
        } else {
            f2 = motionEvent.getX() - this.f35250b;
            float abs = Math.abs(f2);
            float abs2 = Math.abs(motionEvent.getY() - this.f35251c);
            if (abs > this.f35249a && abs > abs2) {
                if (f2 > 0.0f) {
                    this.f35252d = 1;
                } else {
                    this.f35252d = 2;
                }
            }
            sb = new StringBuilder();
            sb.append("onInterceptTouchEvent ACTION_MOVE mDragState=");
            sb.append(this.f35252d);
            sb.append("--dx=");
        }
        sb.append(f2);
        str = sb.toString();
        com.kwad.sdk.core.d.a.a("SwipeLayout", str);
        if (this.f35252d != 0) {
        }
    }

    private synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            synchronized (this) {
                for (a aVar : this.f35254f) {
                    aVar.b();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0014, code lost:
        if (r0 != 3) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00aa A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b(MotionEvent motionEvent) {
        InterceptResult invokeL;
        StringBuilder sb;
        float f2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, motionEvent)) != null) {
            return invokeL.booleanValue;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                com.kwad.sdk.core.d.a.a("SwipeLayout", "onTouchEvent ACTION_UP mDragState=" + this.f35252d);
                List<a> list = this.f35254f;
                if (list != null && !list.isEmpty() && (i2 = this.f35252d) != 0) {
                    if (i2 == 1) {
                        c();
                    } else if (i2 == 2) {
                        b();
                    }
                }
            } else if (action == 2) {
                f2 = motionEvent.getX() - this.f35250b;
                float abs = Math.abs(f2);
                float abs2 = Math.abs(motionEvent.getY() - this.f35251c);
                if (this.f35252d == 0 && abs > this.f35249a && abs > abs2) {
                    if (f2 > 0.0f) {
                        this.f35252d = 1;
                    } else {
                        this.f35252d = 2;
                    }
                }
                sb = new StringBuilder();
                sb.append("onTouchEvent ACTION_MOVE mDragState=");
                sb.append(this.f35252d);
                sb.append("--dx=");
            }
            this.f35252d = 0;
            return this.f35252d == 0;
        }
        sb = new StringBuilder();
        sb.append("onTouchEvent ACTION_DOWN mInitialMotionX=");
        f2 = this.f35250b;
        sb.append(f2);
        com.kwad.sdk.core.d.a.a("SwipeLayout", sb.toString());
        if (this.f35252d == 0) {
        }
    }

    private synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            synchronized (this) {
                for (a aVar : this.f35254f) {
                    aVar.a();
                }
            }
        }
    }

    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                this.f35254f.clear();
            }
        }
    }

    public synchronized void a(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            synchronized (this) {
                this.f35254f.add(aVar);
            }
        }
    }

    public synchronized boolean b(a aVar) {
        InterceptResult invokeL;
        boolean contains;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) {
            synchronized (this) {
                contains = this.f35254f.contains(aVar);
            }
            return contains;
        }
        return invokeL.booleanValue;
    }

    public synchronized void c(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            synchronized (this) {
                this.f35254f.remove(aVar);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        ViewParent parent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            d dVar = this.f35253e;
            if (dVar != null) {
                dVar.d(this, motionEvent);
            }
            List<a> list = this.f35254f;
            if (list != null && !list.isEmpty()) {
                int action = motionEvent.getAction();
                boolean z = true;
                if (action == 0) {
                    parent = getParent();
                } else if (action == 1 || action == 3) {
                    parent = getParent();
                    z = false;
                }
                parent.requestDisallowInterceptTouchEvent(z);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public synchronized List<a> getOnSwipedListeners() {
        InterceptResult invokeV;
        List<a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                list = this.f35254f;
            }
            return list;
        }
        return (List) invokeV.objValue;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            d dVar = this.f35253e;
            if (dVar == null || !dVar.e(this, motionEvent)) {
                List<a> list = this.f35254f;
                return (list == null || list.isEmpty()) ? super.onInterceptTouchEvent(motionEvent) : a(motionEvent);
            }
            com.kwad.sdk.core.d.a.a("SwipeLayout", "onInterceptTouchEvent true");
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, motionEvent)) == null) {
            d dVar = this.f35253e;
            if (dVar == null || !dVar.f(this, motionEvent)) {
                List<a> list = this.f35254f;
                return (list == null || list.isEmpty()) ? super.onTouchEvent(motionEvent) : b(motionEvent);
            }
            com.kwad.sdk.core.d.a.a("SwipeLayout", "handlerTouchEvent true");
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setTouchDetector(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) {
            this.f35253e = dVar;
        }
    }
}
