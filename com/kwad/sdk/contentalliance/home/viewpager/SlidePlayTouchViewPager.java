package com.kwad.sdk.contentalliance.home.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.contentalliance.refreshview.e;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes7.dex */
public class SlidePlayTouchViewPager extends com.kwad.sdk.contentalliance.b.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f35268a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f35269b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f35270c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public e f35271d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f35272e;

    /* renamed from: g  reason: collision with root package name */
    public int f35273g;

    /* renamed from: h  reason: collision with root package name */
    public float f35274h;

    /* renamed from: i  reason: collision with root package name */
    public float f35275i;
    public boolean j;
    public boolean k;
    public BitSet l;
    public List<a> m;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class TargetBoundUpdatedType {
        public static final /* synthetic */ TargetBoundUpdatedType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final TargetBoundUpdatedType ON_MOVE_TO_NEXT;
        public static final TargetBoundUpdatedType ON_MOVE_TO_PRE;
        public static final TargetBoundUpdatedType ON_SCROLL_END;
        public static final TargetBoundUpdatedType RESET;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-347394356, "Lcom/kwad/sdk/contentalliance/home/viewpager/SlidePlayTouchViewPager$TargetBoundUpdatedType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-347394356, "Lcom/kwad/sdk/contentalliance/home/viewpager/SlidePlayTouchViewPager$TargetBoundUpdatedType;");
                    return;
                }
            }
            ON_SCROLL_END = new TargetBoundUpdatedType("ON_SCROLL_END", 0);
            ON_MOVE_TO_NEXT = new TargetBoundUpdatedType("ON_MOVE_TO_NEXT", 1);
            ON_MOVE_TO_PRE = new TargetBoundUpdatedType("ON_MOVE_TO_PRE", 2);
            TargetBoundUpdatedType targetBoundUpdatedType = new TargetBoundUpdatedType("RESET", 3);
            RESET = targetBoundUpdatedType;
            $VALUES = new TargetBoundUpdatedType[]{ON_SCROLL_END, ON_MOVE_TO_NEXT, ON_MOVE_TO_PRE, targetBoundUpdatedType};
        }

        public TargetBoundUpdatedType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static TargetBoundUpdatedType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (TargetBoundUpdatedType) Enum.valueOf(TargetBoundUpdatedType.class, str) : (TargetBoundUpdatedType) invokeL.objValue;
        }

        public static TargetBoundUpdatedType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (TargetBoundUpdatedType[]) $VALUES.clone() : (TargetBoundUpdatedType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface a {
        void a();

        void b();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SlidePlayTouchViewPager(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlidePlayTouchViewPager(Context context, AttributeSet attributeSet) {
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
        this.l = new BitSet();
        this.f35272e = true;
        this.m = new ArrayList();
    }

    private void b(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, this, motionEvent) == null) && motionEvent.getActionMasked() == 0) {
            this.f35274h = motionEvent.getX();
            this.f35275i = motionEvent.getY();
            this.k = false;
            this.j = false;
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.j = false;
        }
    }

    private boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, this)) == null) ? !this.f35272e || getAdapter() == null : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.contentalliance.b.b
    public int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (getCurrentItem() <= getFirstValidItemPosition()) {
                int i3 = this.f35273g;
                if (i2 - i3 < 0) {
                    return i3;
                }
            }
            if (getCurrentItem() >= getLastValidItemPosition()) {
                int i4 = this.f35273g;
                if (i2 - i4 > 0) {
                    return i4;
                }
            }
            return super.a(i2);
        }
        return invokeI.intValue;
    }

    @Override // com.kwad.sdk.contentalliance.b.b
    public int a(int i2, float f2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) ? Math.max(Math.min(super.a(i2, f2, i3, i4), getLastValidItemPosition()), getFirstValidItemPosition()) : invokeCommon.intValue;
    }

    @Override // com.kwad.sdk.contentalliance.b.b
    public void a(int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            super.a(i2, z, z2);
            a(TargetBoundUpdatedType.RESET);
        }
    }

    public void a(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, motionEvent) == null) && this.f35269b) {
            float abs = Math.abs(motionEvent.getX() - this.f35274h);
            float y = motionEvent.getY();
            float abs2 = Math.abs(y - this.f35275i);
            if (abs2 <= this.f34305f || abs2 * 0.5f <= abs) {
                return;
            }
            if (!this.f35268a && y > this.f35275i && getCurrentItem() == getFirstValidItemPosition()) {
                if (!this.f35270c) {
                    e();
                }
                for (a aVar : this.m) {
                    aVar.a();
                }
            } else if (getCurrentItem() == getLastValidItemPosition() && !f() && y < this.f35275i) {
                d();
                for (a aVar2 : this.m) {
                    aVar2.b();
                }
            }
        }
    }

    public void a(TargetBoundUpdatedType targetBoundUpdatedType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, targetBoundUpdatedType) == null) {
            this.f35273g = targetBoundUpdatedType == TargetBoundUpdatedType.ON_SCROLL_END ? getScrollY() : targetBoundUpdatedType == TargetBoundUpdatedType.RESET ? 0 : targetBoundUpdatedType == TargetBoundUpdatedType.ON_MOVE_TO_NEXT ? this.f35273g + getHeight() : this.f35273g - getHeight();
        }
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) || this.m.contains(aVar)) {
            return;
        }
        this.m.add(aVar);
    }

    public void a(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            com.kwad.sdk.core.d.a.a("SlidePlayTouchViewPager", "enable:" + z + ";flag:" + i2);
            if (z) {
                this.l.clear(i2);
            } else {
                this.l.set(i2);
            }
            this.f35272e = this.l.cardinality() == 0;
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? !this.f35272e : invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.l.clear();
            this.f35272e = this.l.cardinality() == 0;
        }
    }

    public void b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            this.m.remove(aVar);
        }
    }

    @Override // com.kwad.sdk.contentalliance.b.b
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.c();
            a(TargetBoundUpdatedType.ON_SCROLL_END);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public int getFirstValidItemPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public int getLastValidItemPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? getAdapter().getCount() - 1 : invokeV.intValue;
    }

    @Override // com.kwad.sdk.contentalliance.b.b, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, motionEvent)) == null) {
            if (h()) {
                return false;
            }
            int action = motionEvent.getAction() & 255;
            b(motionEvent);
            if (action == 2) {
                float abs = Math.abs(motionEvent.getX() - this.f35274h);
                float y = motionEvent.getY();
                float f2 = this.f35275i;
                float f3 = y - f2;
                float abs2 = Math.abs(y - f2);
                if (getCurrentItem() == getFirstValidItemPosition() && f3 > this.f34305f && abs2 * 0.5f > abs) {
                    this.j = true;
                    e eVar = this.f35271d;
                    if (eVar != null && this.f35268a) {
                        eVar.a(motionEvent);
                    }
                    return true;
                } else if (getCurrentItem() == getLastValidItemPosition() && f3 < (-this.f34305f) && abs2 * 0.5f > abs) {
                    this.k = true;
                    return true;
                }
            }
            e eVar2 = this.f35271d;
            if (eVar2 != null && this.f35268a) {
                eVar2.a(motionEvent);
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001b, code lost:
        if (r0 != 2) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x009f  */
    @Override // com.kwad.sdk.contentalliance.b.b, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048593, this, motionEvent)) != null) {
            return invokeL.booleanValue;
        }
        if (h()) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        b(motionEvent);
        if (action != 0) {
            if (action == 1) {
                a(motionEvent);
            }
            if (this.j) {
                if (this.k) {
                    if (action == 1) {
                        super.onTouchEvent(motionEvent);
                    }
                    return true;
                }
                return super.onTouchEvent(motionEvent);
            }
            if (action == 1 || action == 3) {
                g();
            }
            e eVar2 = this.f35271d;
            if (eVar2 != null && this.f35268a) {
                eVar2.b(motionEvent);
            }
            return true;
        }
        this.k = false;
        this.j = false;
        float abs = Math.abs(motionEvent.getX() - this.f35274h);
        float y = motionEvent.getY();
        float f2 = this.f35275i;
        float f3 = y - f2;
        float abs2 = Math.abs(y - f2);
        if (getCurrentItem() == getFirstValidItemPosition()) {
            if (f3 > this.f34305f && abs2 * 0.5f > abs) {
                this.j = true;
            }
            if (!this.j && f3 > 0.0f && (eVar = this.f35271d) != null && this.f35268a) {
                eVar.b(motionEvent);
            }
        }
        if (getCurrentItem() == getLastValidItemPosition() && f3 < (-this.f34305f) && abs2 * 0.5f > abs) {
            this.k = true;
        }
        if (this.j) {
        }
    }

    @Override // com.kwad.sdk.contentalliance.b.b
    public void setAdapter(PagerAdapter pagerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, pagerAdapter) == null) {
            super.setAdapter(pagerAdapter);
            a(TargetBoundUpdatedType.RESET);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            super.setEnabled(z);
            a(z, 1);
        }
    }
}
