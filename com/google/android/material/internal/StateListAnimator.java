package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes7.dex */
public final class StateListAnimator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Animator.AnimatorListener animationListener;
    @Nullable
    public Tuple lastMatch;
    @Nullable
    public ValueAnimator runningAnimator;
    public final ArrayList<Tuple> tuples;

    /* loaded from: classes7.dex */
    public static class Tuple {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ValueAnimator animator;
        public final int[] specs;

        public Tuple(int[] iArr, ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iArr, valueAnimator};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.specs = iArr;
            this.animator = valueAnimator;
        }
    }

    public StateListAnimator() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.tuples = new ArrayList<>();
        this.lastMatch = null;
        this.runningAnimator = null;
        this.animationListener = new AnimatorListenerAdapter(this) { // from class: com.google.android.material.internal.StateListAnimator.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ StateListAnimator this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                    StateListAnimator stateListAnimator = this.this$0;
                    if (stateListAnimator.runningAnimator == animator) {
                        stateListAnimator.runningAnimator = null;
                    }
                }
            }
        };
    }

    private void cancel() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || (valueAnimator = this.runningAnimator) == null) {
            return;
        }
        valueAnimator.cancel();
        this.runningAnimator = null;
    }

    private void start(@NonNull Tuple tuple) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, tuple) == null) {
            ValueAnimator valueAnimator = tuple.animator;
            this.runningAnimator = valueAnimator;
            valueAnimator.start();
        }
    }

    public void addState(int[] iArr, ValueAnimator valueAnimator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, iArr, valueAnimator) == null) {
            Tuple tuple = new Tuple(iArr, valueAnimator);
            valueAnimator.addListener(this.animationListener);
            this.tuples.add(tuple);
        }
    }

    public void jumpToCurrentState() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (valueAnimator = this.runningAnimator) == null) {
            return;
        }
        valueAnimator.end();
        this.runningAnimator = null;
    }

    public void setState(int[] iArr) {
        Tuple tuple;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iArr) == null) {
            int size = this.tuples.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    tuple = null;
                    break;
                }
                tuple = this.tuples.get(i);
                if (StateSet.stateSetMatches(tuple.specs, iArr)) {
                    break;
                }
                i++;
            }
            Tuple tuple2 = this.lastMatch;
            if (tuple == tuple2) {
                return;
            }
            if (tuple2 != null) {
                cancel();
            }
            this.lastMatch = tuple;
            if (tuple != null) {
                start(tuple);
            }
        }
    }
}
