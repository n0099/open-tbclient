package com.ksad.lottie.a.a;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
@TargetApi(19)
/* loaded from: classes7.dex */
public class k implements i, l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Path f33626a;

    /* renamed from: b  reason: collision with root package name */
    public final Path f33627b;

    /* renamed from: c  reason: collision with root package name */
    public final Path f33628c;

    /* renamed from: d  reason: collision with root package name */
    public final String f33629d;

    /* renamed from: e  reason: collision with root package name */
    public final List<l> f33630e;

    /* renamed from: f  reason: collision with root package name */
    public final MergePaths f33631f;

    /* renamed from: com.ksad.lottie.a.a.k$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f33632a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-555439771, "Lcom/ksad/lottie/a/a/k$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-555439771, "Lcom/ksad/lottie/a/a/k$1;");
                    return;
                }
            }
            int[] iArr = new int[MergePaths.MergePathsMode.values().length];
            f33632a = iArr;
            try {
                iArr[MergePaths.MergePathsMode.Merge.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33632a[MergePaths.MergePathsMode.Add.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33632a[MergePaths.MergePathsMode.Subtract.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33632a[MergePaths.MergePathsMode.Intersect.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f33632a[MergePaths.MergePathsMode.ExcludeIntersections.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public k(MergePaths mergePaths) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mergePaths};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33626a = new Path();
        this.f33627b = new Path();
        this.f33628c = new Path();
        this.f33630e = new ArrayList();
        if (Build.VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.f33629d = mergePaths.a();
        this.f33631f = mergePaths;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            for (int i2 = 0; i2 < this.f33630e.size(); i2++) {
                this.f33628c.addPath(this.f33630e.get(i2).d());
            }
        }
    }

    @TargetApi(19)
    private void a(Path.Op op) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, op) == null) {
            this.f33627b.reset();
            this.f33626a.reset();
            for (int size = this.f33630e.size() - 1; size >= 1; size--) {
                l lVar = this.f33630e.get(size);
                if (lVar instanceof c) {
                    c cVar = (c) lVar;
                    List<l> b2 = cVar.b();
                    for (int size2 = b2.size() - 1; size2 >= 0; size2--) {
                        Path d2 = b2.get(size2).d();
                        d2.transform(cVar.c());
                        this.f33627b.addPath(d2);
                    }
                } else {
                    this.f33627b.addPath(lVar.d());
                }
            }
            l lVar2 = this.f33630e.get(0);
            if (lVar2 instanceof c) {
                c cVar2 = (c) lVar2;
                List<l> b3 = cVar2.b();
                for (int i2 = 0; i2 < b3.size(); i2++) {
                    Path d3 = b3.get(i2).d();
                    d3.transform(cVar2.c());
                    this.f33626a.addPath(d3);
                }
            } else {
                this.f33626a.set(lVar2.d());
            }
            this.f33628c.op(this.f33626a, this.f33627b, op);
        }
    }

    @Override // com.ksad.lottie.a.a.b
    public void a(List<b> list, List<b> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, list, list2) == null) {
            for (int i2 = 0; i2 < this.f33630e.size(); i2++) {
                this.f33630e.get(i2).a(list, list2);
            }
        }
    }

    @Override // com.ksad.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, listIterator) == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            while (listIterator.hasPrevious()) {
                b previous = listIterator.previous();
                if (previous instanceof l) {
                    this.f33630e.add((l) previous);
                    listIterator.remove();
                }
            }
        }
    }

    @Override // com.ksad.lottie.a.a.l
    public Path d() {
        InterceptResult invokeV;
        Path.Op op;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            this.f33628c.reset();
            int i2 = AnonymousClass1.f33632a[this.f33631f.b().ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    op = Path.Op.UNION;
                } else if (i2 == 3) {
                    op = Path.Op.REVERSE_DIFFERENCE;
                } else if (i2 == 4) {
                    op = Path.Op.INTERSECT;
                } else if (i2 == 5) {
                    op = Path.Op.XOR;
                }
                a(op);
            } else {
                a();
            }
            return this.f33628c;
        }
        return (Path) invokeV.objValue;
    }
}
