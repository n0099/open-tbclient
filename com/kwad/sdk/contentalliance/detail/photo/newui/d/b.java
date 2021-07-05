package com.kwad.sdk.contentalliance.detail.photo.newui.d;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Handler;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.ao;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f34880a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f34881b;

    /* renamed from: c  reason: collision with root package name */
    public AnimatorSet f34882c;

    /* renamed from: d  reason: collision with root package name */
    public AnimatorSet f34883d;

    /* renamed from: e  reason: collision with root package name */
    public AnimatorSet f34884e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f34885f;

    /* renamed from: g  reason: collision with root package name */
    public a f34886g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f34887h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f34888i;
    public Runnable j;

    /* loaded from: classes7.dex */
    public interface a {
        void a();

        void b();
    }

    public b(@NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull Handler handler, @NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageView, imageView2, handler, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34882c = new AnimatorSet();
        this.f34883d = new AnimatorSet();
        this.f34884e = new AnimatorSet();
        this.f34887h = new Runnable(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.d.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f34889a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34889a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f34889a.b();
                }
            }
        };
        this.f34888i = new Runnable(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.d.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f34890a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34890a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f34890a.d();
                }
            }
        };
        this.j = new Runnable(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.d.b.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f34891a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34891a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f34891a.f34881b == null) {
                    return;
                }
                this.f34891a.f34881b.setVisibility(0);
                this.f34891a.f34881b.setPivotX(ao.a(this.f34891a.f34881b.getContext(), 154.0f));
                this.f34891a.f34881b.setPivotY(ao.a(this.f34891a.f34881b.getContext(), 27.0f));
                this.f34891a.f34881b.invalidate();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f34891a.f34881b, "alpha", 0.0f, 1.0f);
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f34891a.f34881b, "scaleX", 0.5f, 1.0f);
                ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f34891a.f34881b, "scaleY", 0.5f, 1.0f);
                ArrayList arrayList = new ArrayList();
                arrayList.add(ofFloat);
                arrayList.add(ofFloat2);
                arrayList.add(ofFloat3);
                this.f34891a.f34883d.playTogether(arrayList);
                this.f34891a.f34883d.setDuration(300L);
                this.f34891a.f34883d.start();
            }
        };
        this.f34880a = imageView;
        this.f34881b = imageView2;
        this.f34886g = aVar;
        this.f34885f = handler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || this.f34881b == null || this.f34880a == null) {
            return;
        }
        a aVar = this.f34886g;
        if (aVar != null) {
            aVar.a();
        }
        c();
        this.f34885f.postDelayed(this.j, 500L);
        this.f34885f.postDelayed(this.f34888i, 3000L);
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f34880a, "scaleX", 1.1f, 1.0f, 1.1f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f34880a, "scaleY", 1.1f, 1.0f, 1.1f);
            ofFloat.setRepeatCount(-1);
            ofFloat2.setRepeatCount(-1);
            this.f34882c.setDuration(600L);
            this.f34882c.play(ofFloat).with(ofFloat2);
            this.f34882c.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            a aVar = this.f34886g;
            if (aVar != null) {
                aVar.b();
            }
            ImageView imageView = this.f34881b;
            if (imageView != null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "alpha", 1.0f, 0.0f);
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f34881b, "scaleX", 1.0f, 0.5f);
                ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f34881b, "scaleY", 1.0f, 0.5f);
                ArrayList arrayList = new ArrayList();
                arrayList.add(ofFloat);
                arrayList.add(ofFloat2);
                arrayList.add(ofFloat3);
                this.f34884e.playTogether(arrayList);
                this.f34884e.setDuration(300L);
                this.f34884e.start();
            }
            AnimatorSet animatorSet = this.f34882c;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a aVar = this.f34886g;
            if (aVar != null) {
                aVar.b();
            }
            Handler handler = this.f34885f;
            if (handler != null) {
                handler.removeCallbacks(this.j);
                this.f34885f.removeCallbacks(this.f34887h);
                this.f34885f.removeCallbacks(this.f34888i);
            }
            ImageView imageView = this.f34881b;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            AnimatorSet animatorSet = this.f34883d;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = this.f34884e;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            AnimatorSet animatorSet3 = this.f34882c;
            if (animatorSet3 != null) {
                animatorSet3.cancel();
            }
            this.f34880a = null;
            this.f34881b = null;
            this.f34886g = null;
        }
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.f34885f.postDelayed(this.f34887h, j);
        }
    }
}
