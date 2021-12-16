package com.tachikoma.core.component;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewParent;
import android.widget.ListView;
import androidx.annotation.CallSuper;
import androidx.annotation.ColorInt;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.lottie.LottieComposition;
import com.kwad.lottie.LottieCompositionFactory;
import com.kwad.lottie.LottieDrawable;
import com.kwad.lottie.LottieListener;
import com.kwad.lottie.LottieTask;
import com.kwad.sdk.R;
import com.kwad.v8.JavaCallback;
import com.kwad.v8.V8Array;
import com.kwad.v8.V8Function;
import com.kwad.v8.V8Object;
import com.kwad.v8.V8Value;
import com.kwad.v8.utils.V8ObjectUtils;
import com.kwad.yoga.YogaEdge;
import com.tachikoma.core.IV8Function;
import com.tachikoma.core.Tachikoma;
import com.tachikoma.core.V8FunctionImpl;
import com.tachikoma.core.bridge.JSContext;
import com.tachikoma.core.bridge.TKJSContext;
import com.tachikoma.core.common.ILifeCycle;
import com.tachikoma.core.component.anim.AnimationProperty;
import com.tachikoma.core.component.anim.CustomViewPropertyAnimator;
import com.tachikoma.core.component.anim.TKBasicAnimation;
import com.tachikoma.core.component.anim.TKKeyframeAnimation;
import com.tachikoma.core.component.view.TKViewBackgroundDrawable;
import com.tachikoma.core.component.view.ViewBackgroundManager;
import com.tachikoma.core.event.TKEventProcess;
import com.tachikoma.core.event.base.GestureUtils;
import com.tachikoma.core.event.base.IBaseEvent;
import com.tachikoma.core.event.base.TKBaseEvent;
import com.tachikoma.core.event.guesture.TKTapEvent;
import com.tachikoma.core.exception.TKExceptionDispatcher;
import com.tachikoma.core.layout.TKDomNode;
import com.tachikoma.core.log.Logger;
import com.tachikoma.core.utility.SizeUtil;
import com.tachikoma.core.utility.TKColorUtil;
import com.tachikoma.core.utility.TKConverter;
import com.tachikoma.core.utility.TKEnv;
import com.tachikoma.core.utility.V8Proxy;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public abstract class TKBase<T extends View> implements ILifeCycle {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DISPLAY_INLINE = "inline";
    public static final String DISPLAY_NONE = "none";
    public static final String VISIBILITY_HIDDEN = "hidden";
    public static final String VISIBILITY_VISIBLE = "visible";
    public transient /* synthetic */ FieldHolder $fh;
    public List<JSContext.V8AssociateReference> associateAnimationRefList;
    public boolean enabled;
    public HashMap<String, V8Function> eventListener;
    public boolean isClickInit;
    public String lottiePath;
    public String lottieRes;
    public Map<String, TKBasicAnimation> mAnimationMap;
    public HashMap<Float, Map<String, Object>> mAnimationPropertySnapshot;
    public String mBackgroundColor;
    public float mBorderRadius;
    public GestureDetector mGestureDetector;
    public IJS2NativeInvoker mIJS2NativeInvoker;
    public MotionEvent mLatestMotionEvent;
    public TKDomNode mNode;
    public ScaleGestureDetector mScaleGestureDetector;
    public TKJSContext mTKJSContext;
    public T mTargetView;
    public V8Object mV8This;
    public TKBase rootTkBase;
    public HashMap style;
    public ViewBackgroundManager viewBackgroundManager;
    public String viewID;

    /* loaded from: classes3.dex */
    public interface IJS2NativeInvoker {
        Object onJSInvokeNativeWithJSONString(String str, String str2, IV8Function iV8Function);
    }

    public TKBase(Context context, List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.eventListener = new HashMap<>();
        this.mAnimationMap = new HashMap();
        this.isClickInit = false;
        this.mAnimationPropertySnapshot = new LinkedHashMap();
        this.associateAnimationRefList = new ArrayList();
        this.mTKJSContext = V8Proxy.getTKContext(list);
        T createView = createView(context);
        this.mTargetView = createView;
        if (createView != null) {
            createView.setTag(R.id.tk_node, this);
        }
        this.mNode = TKDomNode.nodeForView(this, list);
        this.viewBackgroundManager = new ViewBackgroundManager(getView());
        this.rootTkBase = this;
    }

    private void backtrackRoot(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, view) == null) || view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            Object tag = view2.getTag(R.id.tk_node);
            if (tag instanceof TKBase) {
                this.rootTkBase = (TKBase) tag;
            }
            backtrackRoot(view2);
        }
    }

    private T createView(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, this, context)) == null) ? createViewInstance(context) : (T) invokeL.objValue;
    }

    private void destroyAnimation() {
        Map<String, TKBasicAnimation> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || (map = this.mAnimationMap) == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, TKBasicAnimation> entry : this.mAnimationMap.entrySet()) {
            if (entry != null && entry.getValue() != null) {
                entry.getValue().destroyAnimation();
            }
        }
    }

    private void executeAnimationJsFunction(TKBasicAnimation tKBasicAnimation) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, this, tKBasicAnimation) == null) && tKBasicAnimation.newVersionEnable()) {
            backtrackRoot(getView());
            this.mAnimationPropertySnapshot.clear();
            this.mAnimationPropertySnapshot.put(Float.valueOf(0.0f), makeAnimationPropertySnapshot());
            TKBasicAnimation.AnimationJsCallback animationJsCallback = new TKBasicAnimation.AnimationJsCallback(this) { // from class: com.tachikoma.core.component.TKBase.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TKBase this$0;

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
                    this.this$0 = this;
                }

                @Override // com.tachikoma.core.component.anim.TKBasicAnimation.AnimationJsCallback
                public void onJsExecuteComplete(double d2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Double.valueOf(d2)}) == null) {
                        if (this.this$0.rootTkBase != null && this.this$0.rootTkBase.getDomNode() != null) {
                            this.this$0.rootTkBase.getDomNode().layoutSubviews();
                        }
                        this.this$0.mAnimationPropertySnapshot.put(new Float(d2), this.this$0.makeAnimationPropertySnapshot());
                    }
                }
            };
            tKBasicAnimation.executeStartValueFunction(animationJsCallback);
            tKBasicAnimation.executeEndValueFunction(animationJsCallback);
            boolean z = tKBasicAnimation instanceof TKKeyframeAnimation;
            if (z) {
                ((TKKeyframeAnimation) tKBasicAnimation).executeAnimationFunction(animationJsCallback);
            }
            if (!z || this.mAnimationMap.containsKey(Float.valueOf(1.0f))) {
                return;
            }
            this.mAnimationPropertySnapshot.put(Float.valueOf(1.0f), makeAnimationPropertySnapshot());
        }
    }

    public static <T extends View> TKBase<T> getTKBaseFromView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, view)) == null) ? (TKBase) view.getTag(R.id.tk_node) : (TKBase) invokeL.objValue;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void initViewGestureEvent() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65548, this) == null) && this.mTargetView != null && this.mGestureDetector == null) {
            this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.OnGestureListener(this) { // from class: com.tachikoma.core.component.TKBase.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TKBase this$0;

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
                    this.this$0 = this;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onDown(MotionEvent motionEvent) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, motionEvent)) == null) {
                        this.this$0.dispatchEvent("down", new TKEventProcess.EventInterface(this, motionEvent) { // from class: com.tachikoma.core.component.TKBase.2.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass2 this$1;
                            public final /* synthetic */ MotionEvent val$e;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, motionEvent};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                                this.val$e = motionEvent;
                            }

                            @Override // com.tachikoma.core.event.TKEventProcess.EventInterface
                            public void callBackEvent(IBaseEvent iBaseEvent) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, iBaseEvent) == null) {
                                    iBaseEvent.setType("down");
                                    iBaseEvent.setState(GestureUtils.findStateInMotionEvent(this.val$e));
                                    iBaseEvent.configWithData(new HashMap<String, Object>(this) { // from class: com.tachikoma.core.component.TKBase.2.1.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ AnonymousClass1 this$2;

                                        {
                                            Interceptable interceptable4 = $ic;
                                            if (interceptable4 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this};
                                                interceptable4.invokeUnInit(65536, newInitContext);
                                                int i2 = newInitContext.flag;
                                                if ((i2 & 1) != 0) {
                                                    int i3 = i2 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable4.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.this$2 = this;
                                            put("x", Integer.valueOf(SizeUtil.px2Dp(this.this$2.val$e.getX())));
                                            put("y", Integer.valueOf(SizeUtil.px2Dp(this.this$2.val$e.getY())));
                                        }
                                    });
                                }
                            }
                        });
                        return true;
                    }
                    return invokeL.booleanValue;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                    InterceptResult invokeCommon;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                        this.this$0.dispatchEvent(TKBaseEvent.TK_SWIPE_EVENT_NAME, new TKEventProcess.EventInterface(this, motionEvent, motionEvent2, f2, f3) { // from class: com.tachikoma.core.component.TKBase.2.5
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass2 this$1;
                            public final /* synthetic */ MotionEvent val$e1;
                            public final /* synthetic */ MotionEvent val$e2;
                            public final /* synthetic */ float val$velocityX;
                            public final /* synthetic */ float val$velocityY;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                                this.val$e1 = motionEvent;
                                this.val$e2 = motionEvent2;
                                this.val$velocityX = f2;
                                this.val$velocityY = f3;
                            }

                            @Override // com.tachikoma.core.event.TKEventProcess.EventInterface
                            public void callBackEvent(IBaseEvent iBaseEvent) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, iBaseEvent) == null) {
                                    iBaseEvent.setType(TKBaseEvent.TK_SWIPE_EVENT_NAME);
                                    iBaseEvent.setState(2);
                                    if (this.val$e1.getAction() == 0) {
                                        iBaseEvent.setState(1);
                                    }
                                    if (this.val$e2.getAction() == 1) {
                                        iBaseEvent.setState(3);
                                    } else if (this.val$e2.getAction() == 3) {
                                        iBaseEvent.setState(4);
                                    }
                                    iBaseEvent.configWithData(new HashMap<String, Object>(this) { // from class: com.tachikoma.core.component.TKBase.2.5.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ AnonymousClass5 this$2;

                                        {
                                            Interceptable interceptable4 = $ic;
                                            if (interceptable4 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this};
                                                interceptable4.invokeUnInit(65536, newInitContext);
                                                int i2 = newInitContext.flag;
                                                if ((i2 & 1) != 0) {
                                                    int i3 = i2 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable4.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.this$2 = this;
                                            put("beginX", Integer.valueOf(SizeUtil.px2Dp(this.this$2.val$e1.getX())));
                                            put("beginY", Integer.valueOf(SizeUtil.px2Dp(this.this$2.val$e1.getY())));
                                            put("endX", Integer.valueOf(SizeUtil.px2Dp(this.this$2.val$e2.getX())));
                                            put("endY", Integer.valueOf(SizeUtil.px2Dp(this.this$2.val$e2.getY())));
                                            put("velocityX", Integer.valueOf(SizeUtil.px2Dp(this.this$2.val$velocityX)));
                                            put("velocityY", Integer.valueOf(SizeUtil.px2Dp(this.this$2.val$velocityY)));
                                        }
                                    });
                                }
                            }
                        });
                        return false;
                    }
                    return invokeCommon.booleanValue;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public void onLongPress(MotionEvent motionEvent) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent) == null) {
                        this.this$0.dispatchEvent(TKBaseEvent.TK_LONG_PRESS_EVENT_NAME, new TKEventProcess.EventInterface(this, motionEvent) { // from class: com.tachikoma.core.component.TKBase.2.4
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass2 this$1;
                            public final /* synthetic */ MotionEvent val$e;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, motionEvent};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                                this.val$e = motionEvent;
                            }

                            @Override // com.tachikoma.core.event.TKEventProcess.EventInterface
                            public void callBackEvent(IBaseEvent iBaseEvent) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, iBaseEvent) == null) {
                                    iBaseEvent.setType(TKBaseEvent.TK_LONG_PRESS_EVENT_NAME);
                                    iBaseEvent.setState(GestureUtils.findStateInMotionEvent(this.val$e));
                                    iBaseEvent.configWithData(new HashMap<String, Object>(this) { // from class: com.tachikoma.core.component.TKBase.2.4.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ AnonymousClass4 this$2;

                                        {
                                            Interceptable interceptable4 = $ic;
                                            if (interceptable4 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this};
                                                interceptable4.invokeUnInit(65536, newInitContext);
                                                int i2 = newInitContext.flag;
                                                if ((i2 & 1) != 0) {
                                                    int i3 = i2 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable4.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.this$2 = this;
                                            put("x", Integer.valueOf(SizeUtil.px2Dp(this.this$2.val$e.getX())));
                                            put("y", Integer.valueOf(SizeUtil.px2Dp(this.this$2.val$e.getY())));
                                        }
                                    });
                                }
                            }
                        });
                    }
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                    InterceptResult invokeCommon;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048579, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                        this.this$0.dispatchEvent(TKBaseEvent.TK_PAN_EVENT_NAME, new TKEventProcess.EventInterface(this, motionEvent, motionEvent2, f2, f3) { // from class: com.tachikoma.core.component.TKBase.2.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass2 this$1;
                            public final /* synthetic */ float val$distanceX;
                            public final /* synthetic */ float val$distanceY;
                            public final /* synthetic */ MotionEvent val$e1;
                            public final /* synthetic */ MotionEvent val$e2;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                                this.val$e1 = motionEvent;
                                this.val$e2 = motionEvent2;
                                this.val$distanceX = f2;
                                this.val$distanceY = f3;
                            }

                            @Override // com.tachikoma.core.event.TKEventProcess.EventInterface
                            public void callBackEvent(IBaseEvent iBaseEvent) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, iBaseEvent) == null) {
                                    iBaseEvent.setType(TKBaseEvent.TK_PAN_EVENT_NAME);
                                    if (this.val$e1.getAction() == 0) {
                                        iBaseEvent.setState(1);
                                    }
                                    if (this.val$e2.getAction() == 1) {
                                        iBaseEvent.setState(3);
                                    } else if (this.val$e2.getAction() == 3) {
                                        iBaseEvent.setState(4);
                                    }
                                    iBaseEvent.configWithData(new HashMap<String, Object>(this) { // from class: com.tachikoma.core.component.TKBase.2.3.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ AnonymousClass3 this$2;

                                        {
                                            Interceptable interceptable4 = $ic;
                                            if (interceptable4 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this};
                                                interceptable4.invokeUnInit(65536, newInitContext);
                                                int i2 = newInitContext.flag;
                                                if ((i2 & 1) != 0) {
                                                    int i3 = i2 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable4.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.this$2 = this;
                                            put("deltaX", Integer.valueOf(SizeUtil.px2Dp(this.this$2.val$distanceX)));
                                            put("deltaY", Integer.valueOf(SizeUtil.px2Dp(this.this$2.val$distanceY)));
                                        }
                                    });
                                }
                            }
                        });
                        return true;
                    }
                    return invokeCommon.booleanValue;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public void onShowPress(MotionEvent motionEvent) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048580, this, motionEvent) == null) {
                    }
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onSingleTapUp(MotionEvent motionEvent) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048581, this, motionEvent)) == null) {
                        this.this$0.dispatchEvent(TKBaseEvent.TK_CLICK_EVENT_NAME, new TKEventProcess.EventInterface(this, motionEvent) { // from class: com.tachikoma.core.component.TKBase.2.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass2 this$1;
                            public final /* synthetic */ MotionEvent val$e;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, motionEvent};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                                this.val$e = motionEvent;
                            }

                            @Override // com.tachikoma.core.event.TKEventProcess.EventInterface
                            public void callBackEvent(IBaseEvent iBaseEvent) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, iBaseEvent) == null) {
                                    iBaseEvent.setType(TKBaseEvent.TK_CLICK_EVENT_NAME);
                                    iBaseEvent.setState(GestureUtils.findStateInMotionEvent(this.val$e));
                                    iBaseEvent.configWithData(new HashMap<String, Object>(this) { // from class: com.tachikoma.core.component.TKBase.2.2.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ C22092 this$2;

                                        {
                                            Interceptable interceptable4 = $ic;
                                            if (interceptable4 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this};
                                                interceptable4.invokeUnInit(65536, newInitContext);
                                                int i2 = newInitContext.flag;
                                                if ((i2 & 1) != 0) {
                                                    int i3 = i2 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable4.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.this$2 = this;
                                            put("x", Integer.valueOf(SizeUtil.px2Dp(this.this$2.val$e.getX())));
                                            put("y", Integer.valueOf(SizeUtil.px2Dp(this.this$2.val$e.getY())));
                                        }
                                    });
                                }
                            }
                        });
                        return false;
                    }
                    return invokeL.booleanValue;
                }
            });
            this.mScaleGestureDetector = new ScaleGestureDetector(getContext(), new ScaleGestureDetector.SimpleOnScaleGestureListener(this) { // from class: com.tachikoma.core.component.TKBase.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TKBase this$0;

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
                    this.this$0 = this;
                }

                @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
                public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, scaleGestureDetector)) == null) {
                        this.this$0.dispatchEvent(TKBaseEvent.TK_PINCH_EVENT_NAME, new TKEventProcess.EventInterface(this, scaleGestureDetector.getScaleFactor()) { // from class: com.tachikoma.core.component.TKBase.3.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass3 this$1;
                            public final /* synthetic */ float val$scale;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, Float.valueOf(r7)};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                                this.val$scale = r7;
                            }

                            @Override // com.tachikoma.core.event.TKEventProcess.EventInterface
                            public void callBackEvent(IBaseEvent iBaseEvent) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, iBaseEvent) == null) {
                                    iBaseEvent.setType(TKBaseEvent.TK_PINCH_EVENT_NAME);
                                    iBaseEvent.setState(GestureUtils.findStateInMotionEvent(this.this$1.this$0.mLatestMotionEvent));
                                    iBaseEvent.configWithData(new HashMap<String, Object>(this) { // from class: com.tachikoma.core.component.TKBase.3.1.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ AnonymousClass1 this$2;

                                        {
                                            Interceptable interceptable4 = $ic;
                                            if (interceptable4 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this};
                                                interceptable4.invokeUnInit(65536, newInitContext);
                                                int i2 = newInitContext.flag;
                                                if ((i2 & 1) != 0) {
                                                    int i3 = i2 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable4.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.this$2 = this;
                                            put(AnimationProperty.SCALE, Float.valueOf(this.this$2.val$scale));
                                        }
                                    });
                                }
                            }
                        });
                        return true;
                    }
                    return invokeL.booleanValue;
                }
            });
            this.mTargetView.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.tachikoma.core.component.TKBase.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TKBase this$0;

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
                    this.this$0 = this;
                }

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                        this.this$0.mLatestMotionEvent = motionEvent;
                        int actionMasked = motionEvent.getActionMasked();
                        if (actionMasked == 1 || actionMasked == 3) {
                            this.this$0.dispatchEvent("up", new TKEventProcess.EventInterface(this, motionEvent) { // from class: com.tachikoma.core.component.TKBase.4.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass4 this$1;
                                public final /* synthetic */ MotionEvent val$event;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, motionEvent};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                    this.val$event = motionEvent;
                                }

                                @Override // com.tachikoma.core.event.TKEventProcess.EventInterface
                                public void callBackEvent(IBaseEvent iBaseEvent) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeL(1048576, this, iBaseEvent) == null) {
                                        iBaseEvent.setType("up");
                                        iBaseEvent.setState(GestureUtils.findStateInMotionEvent(this.val$event));
                                        iBaseEvent.configWithData(new HashMap<String, Object>(this) { // from class: com.tachikoma.core.component.TKBase.4.1.1
                                            public static /* synthetic */ Interceptable $ic;
                                            public transient /* synthetic */ FieldHolder $fh;
                                            public final /* synthetic */ AnonymousClass1 this$2;

                                            {
                                                Interceptable interceptable4 = $ic;
                                                if (interceptable4 != null) {
                                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                                    newInitContext.initArgs = r2;
                                                    Object[] objArr = {this};
                                                    interceptable4.invokeUnInit(65536, newInitContext);
                                                    int i2 = newInitContext.flag;
                                                    if ((i2 & 1) != 0) {
                                                        int i3 = i2 & 2;
                                                        newInitContext.thisArg = this;
                                                        interceptable4.invokeInitBody(65536, newInitContext);
                                                        return;
                                                    }
                                                }
                                                this.this$2 = this;
                                                put("x", Integer.valueOf(SizeUtil.px2Dp(this.this$2.val$event.getX())));
                                                put("y", Integer.valueOf(SizeUtil.px2Dp(this.this$2.val$event.getY())));
                                            }
                                        });
                                    }
                                }
                            });
                        }
                        this.this$0.mScaleGestureDetector.onTouchEvent(motionEvent);
                        this.this$0.mGestureDetector.onTouchEvent(motionEvent);
                        return true;
                    }
                    return invokeLL.booleanValue;
                }
            });
        }
    }

    private boolean isClick(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.equals(TKBaseEvent.TK_CLICK_EVENT_NAME);
        }
        return invokeL.booleanValue;
    }

    private boolean isGestureEvent(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.equals(TKBaseEvent.TK_PAN_EVENT_NAME) || str.equals(TKBaseEvent.TK_SWIPE_EVENT_NAME) || str.equals(TKBaseEvent.TK_PINCH_EVENT_NAME) || str.equals("down") || str.equals("up") || str.equals(TKBaseEvent.TK_LONG_PRESS_EVENT_NAME);
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> makeAnimationPropertySnapshot() {
        InterceptResult invokeV;
        int color;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            HashMap hashMap = new HashMap();
            T t = this.mTargetView;
            if (t == null) {
                return hashMap;
            }
            hashMap.put(AnimationProperty.TRANSLATE_X, Float.valueOf(t.getTranslationX()));
            hashMap.put(AnimationProperty.TRANSLATE_Y, Float.valueOf(this.mTargetView.getTranslationY()));
            hashMap.put(AnimationProperty.SCALE_X, Float.valueOf(this.mTargetView.getScaleX()));
            hashMap.put(AnimationProperty.SCALE_Y, Float.valueOf(this.mTargetView.getScaleY()));
            hashMap.put(AnimationProperty.ROTATE_X, Float.valueOf(this.mTargetView.getRotationX()));
            hashMap.put(AnimationProperty.ROTATE_Y, Float.valueOf(this.mTargetView.getRotationY()));
            hashMap.put("rotation", Float.valueOf(this.mTargetView.getRotation()));
            hashMap.put(AnimationProperty.BOUNDS, this.mTargetView.getClipBounds());
            hashMap.put(AnimationProperty.OPACITY, Float.valueOf(this.mTargetView.getAlpha()));
            Drawable background = this.mTargetView.getBackground();
            if (!(background instanceof TKViewBackgroundDrawable)) {
                if (background instanceof ColorDrawable) {
                    color = ((ColorDrawable) background).getColor();
                }
                if (getDomNode() != null && getDomNode().getYogaNode() != null) {
                    hashMap.put("width", getDomNode().getYogaNode().getWidth());
                    hashMap.put("height", getDomNode().getYogaNode().getHeight());
                    hashMap.put(AnimationProperty.MARGIN, getDomNode().getYogaNode().getMargin(YogaEdge.ALL));
                    hashMap.put(AnimationProperty.MARGIN_LEFT, Float.valueOf(getDomNode().getYogaNode().getLayoutMargin(YogaEdge.LEFT)));
                    hashMap.put(AnimationProperty.MARGIN_RIGHT, Float.valueOf(getDomNode().getYogaNode().getLayoutMargin(YogaEdge.RIGHT)));
                    hashMap.put(AnimationProperty.MARGIN_TOP, Float.valueOf(getDomNode().getYogaNode().getLayoutMargin(YogaEdge.TOP)));
                    hashMap.put(AnimationProperty.MARGIN_BOTTOM, Float.valueOf(getDomNode().getYogaNode().getLayoutMargin(YogaEdge.BOTTOM)));
                }
                return hashMap;
            }
            color = ((TKViewBackgroundDrawable) background).getColor();
            hashMap.put("backgroundColor", Integer.valueOf(color));
            if (getDomNode() != null) {
                hashMap.put("width", getDomNode().getYogaNode().getWidth());
                hashMap.put("height", getDomNode().getYogaNode().getHeight());
                hashMap.put(AnimationProperty.MARGIN, getDomNode().getYogaNode().getMargin(YogaEdge.ALL));
                hashMap.put(AnimationProperty.MARGIN_LEFT, Float.valueOf(getDomNode().getYogaNode().getLayoutMargin(YogaEdge.LEFT)));
                hashMap.put(AnimationProperty.MARGIN_RIGHT, Float.valueOf(getDomNode().getYogaNode().getLayoutMargin(YogaEdge.RIGHT)));
                hashMap.put(AnimationProperty.MARGIN_TOP, Float.valueOf(getDomNode().getYogaNode().getLayoutMargin(YogaEdge.TOP)));
                hashMap.put(AnimationProperty.MARGIN_BOTTOM, Float.valueOf(getDomNode().getYogaNode().getLayoutMargin(YogaEdge.BOTTOM)));
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    private void onStyleUpdated(HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, hashMap) == null) {
            Tachikoma.getInstance().getTKExportManager().applyAttributes(getClass().getName(), this, hashMap);
        }
    }

    private void registerPlatformEventListener(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65553, this, str) == null) || this.mTargetView == null) {
            return;
        }
        if (isGestureEvent(str)) {
            initViewGestureEvent();
        } else if (!isClick(str) || this.isClickInit) {
        } else {
            if (TKBaseEvent.TK_CLICK_EVENT_NAME.equals(str)) {
                this.mTargetView.setOnClickListener(new View.OnClickListener(this) { // from class: com.tachikoma.core.component.TKBase.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TKBase this$0;

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
                        this.this$0 = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) && this.this$0.mGestureDetector == null) {
                            this.this$0.dispatchEvent(TKBaseEvent.TK_CLICK_EVENT_NAME, new TKEventProcess.EventInterface(this) { // from class: com.tachikoma.core.component.TKBase.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass1 this$1;

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
                                    this.this$1 = this;
                                }

                                @Override // com.tachikoma.core.event.TKEventProcess.EventInterface
                                public void callBackEvent(IBaseEvent iBaseEvent) {
                                    Interceptable interceptable3 = $ic;
                                    if ((interceptable3 == null || interceptable3.invokeL(1048576, this, iBaseEvent) == null) && (iBaseEvent instanceof TKTapEvent)) {
                                        TKTapEvent tKTapEvent = (TKTapEvent) iBaseEvent;
                                        tKTapEvent.setType(TKBaseEvent.TK_CLICK_EVENT_NAME);
                                        tKTapEvent.setPosition(new HashMap<String, Float>(this) { // from class: com.tachikoma.core.component.TKBase.1.1.1
                                            public static /* synthetic */ Interceptable $ic;
                                            public transient /* synthetic */ FieldHolder $fh;
                                            public final /* synthetic */ C22061 this$2;

                                            {
                                                Interceptable interceptable4 = $ic;
                                                if (interceptable4 != null) {
                                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                                    newInitContext.initArgs = r2;
                                                    Object[] objArr = {this};
                                                    interceptable4.invokeUnInit(65536, newInitContext);
                                                    int i2 = newInitContext.flag;
                                                    if ((i2 & 1) != 0) {
                                                        int i3 = i2 & 2;
                                                        newInitContext.thisArg = this;
                                                        interceptable4.invokeInitBody(65536, newInitContext);
                                                        return;
                                                    }
                                                }
                                                this.this$2 = this;
                                                Float valueOf = Float.valueOf(0.0f);
                                                put("x", valueOf);
                                                put("y", valueOf);
                                            }
                                        });
                                        tKTapEvent.setState(GestureUtils.findStateInMotionEvent(null));
                                    }
                                }
                            });
                        }
                    }
                });
            }
            this.isClickInit = true;
        }
    }

    private int safelyGetPxValue(HashMap hashMap, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, this, hashMap, str)) == null) {
            if (hashMap != null && !TextUtils.isEmpty(str)) {
                try {
                    if (hashMap.containsKey(str)) {
                        return SizeUtil.dp2Px(((Number) hashMap.get(str)).intValue());
                    }
                } catch (Exception unused) {
                }
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void setTransformProperty(Map map) {
        Number number;
        Object obj;
        float dp2px;
        Object obj2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65555, this, map) == null) || map == null || map.size() <= 0) {
            return;
        }
        Object obj3 = map.get(AnimationProperty.SCALE);
        if (obj3 instanceof Map) {
            Map map2 = (Map) obj3;
            Object obj4 = map2.get("x");
            if (obj4 instanceof Number) {
                setScaleX(((Number) obj4).floatValue());
            }
            Object obj5 = map2.get("y");
            if (obj5 instanceof Number) {
                number = (Number) obj5;
                setScaleY(number.floatValue());
            }
            obj = map.get(AnimationProperty.TRANSLATE);
            if (obj instanceof Map) {
                if (obj instanceof Number) {
                    dp2px = TKConverter.dp2px(getContext(), ((Number) obj).floatValue());
                    setTranslateX(dp2px);
                    setTranslateY(dp2px);
                }
                obj2 = map.get(AnimationProperty.ROTATE);
                if (!(obj2 instanceof Map)) {
                }
                setRotate(((Number) obj2).floatValue());
                return;
            }
            Map map3 = (Map) obj;
            Object obj6 = map3.get("x");
            if (obj6 instanceof Number) {
                setTranslateX(TKConverter.dp2px(getContext(), ((Number) obj6).floatValue()));
            }
            Object obj7 = map3.get("y");
            if (obj7 instanceof Number) {
                dp2px = TKConverter.dp2px(getContext(), ((Number) obj7).floatValue());
                setTranslateY(dp2px);
            }
            obj2 = map.get(AnimationProperty.ROTATE);
            if (!(obj2 instanceof Map)) {
                Map map4 = (Map) obj2;
                Object obj8 = map4.get("x");
                if (obj8 instanceof Number) {
                    setRotateX(((Number) obj8).floatValue());
                }
                Object obj9 = map4.get("y");
                if (obj9 instanceof Number) {
                    setRotateY(((Number) obj9).floatValue());
                }
                obj2 = map4.get("z");
                if (!(obj2 instanceof Number)) {
                    return;
                }
            } else if (!(obj2 instanceof Number)) {
                return;
            }
            setRotate(((Number) obj2).floatValue());
            return;
        }
        if (obj3 instanceof Number) {
            number = (Number) obj3;
            setScaleX(number.floatValue());
            setScaleY(number.floatValue());
        }
        obj = map.get(AnimationProperty.TRANSLATE);
        if (obj instanceof Map) {
        }
    }

    public void addAnimation(V8Object v8Object, String str) {
        TKBasicAnimation tKBasicAnimation;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, v8Object, str) == null) {
            JSContext.V8AssociateReference associateReference = this.mTKJSContext.context().getAssociateReference(v8Object);
            TKBasicAnimation tKBasicAnimation2 = (TKBasicAnimation) associateReference.nativeObject;
            if (this.mAnimationMap.containsKey(str) && (tKBasicAnimation = this.mAnimationMap.get(str)) != null) {
                tKBasicAnimation.stop(this);
            }
            if (tKBasicAnimation2 == null) {
                Logger.logE("addAnimation", new NullPointerException("animation is null!!!"));
                associateReference.close();
            } else if (this.mTargetView == null) {
                Logger.logE("addAnimation", new IllegalStateException("tagetView is null!!!"));
                associateReference.close();
            } else {
                executeAnimationJsFunction(tKBasicAnimation2);
                tKBasicAnimation2.start(this);
                this.mAnimationMap.put(str, tKBasicAnimation2);
                this.associateAnimationRefList.add(associateReference);
            }
        }
    }

    public void addEventListener(String str, V8Function v8Function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, v8Function) == null) {
            if (!str.isEmpty() && v8Function != null) {
                this.eventListener.put(str, v8Function.twin());
            }
            V8Proxy.release(v8Function);
            registerPlatformEventListener(str);
        }
    }

    @Deprecated
    public void applyAttributes(V8Object v8Object) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, v8Object) == null) {
            V8Object v8Object2 = (V8Object) v8Object.get("style");
            if (v8Object2 != null && !v8Object2.isUndefined()) {
                setStyle((HashMap) V8ObjectUtils.toMap(v8Object2));
            }
            Tachikoma.getInstance().getTKExportManager().applyProperties(getClass().getName(), this, new HashMap<>(V8ObjectUtils.toMap(v8Object)));
            V8Proxy.release(v8Object);
        }
    }

    public void bindV8This(V8Object v8Object) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, v8Object) == null) {
            V8Object v8Object2 = this.mV8This;
            if (v8Object2 != null) {
                v8Object2.close();
            }
            V8Object twin = v8Object.twin();
            this.mV8This = twin;
            twin.setWeak();
        }
    }

    public abstract T createViewInstance(Context context);

    public final void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            onDestroy();
        }
    }

    public void dispatchEvent(String str, TKEventProcess.EventInterface eventInterface) {
        V8Function v8Function;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, eventInterface) == null) || (v8Function = this.eventListener.get(str)) == null || v8Function.isReleased()) {
            return;
        }
        TKEventProcess.processEventCallBack(v8Function, str, this.mTKJSContext.context(), getContext(), eventInterface);
    }

    public HashMap<Float, Map<String, Object>> getAnimationPropertySnapshot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mAnimationPropertySnapshot : (HashMap) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? getView().getContext() : (Context) invokeV.objValue;
    }

    public TKDomNode getDomNode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mNode : (TKDomNode) invokeV.objValue;
    }

    public boolean getEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.enabled : invokeV.booleanValue;
    }

    public V8Object getOrigin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            V8Object makeObject = this.mTKJSContext.context().makeObject();
            if (getView() != null) {
                try {
                    makeObject.add("x", String.valueOf(SizeUtil.px2Dp((int) getView().getX())));
                    makeObject.add("y", String.valueOf(SizeUtil.px2Dp((int) getView().getY())));
                } catch (Exception unused) {
                }
            }
            return makeObject;
        }
        return (V8Object) invokeV.objValue;
    }

    public String getRootDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mTKJSContext.getRootDir() : (String) invokeV.objValue;
    }

    public V8Object getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            V8Object makeObject = this.mTKJSContext.context().makeObject();
            if (getView() != null) {
                try {
                    makeObject.add("width", String.valueOf(SizeUtil.px2Dp(getView().getWidth())));
                    makeObject.add("height", String.valueOf(SizeUtil.px2Dp(getView().getHeight())));
                } catch (Exception unused) {
                }
            }
            return makeObject;
        }
        return (V8Object) invokeV.objValue;
    }

    public T getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mTargetView : (T) invokeV.objValue;
    }

    public ViewBackgroundManager getViewBackgroundManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.viewBackgroundManager : (ViewBackgroundManager) invokeV.objValue;
    }

    public String getViewID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? getDomNode().nodeID : (String) invokeV.objValue;
    }

    public Object invokeJSFunctionWithJSONString(String str, String str2, JavaCallback javaCallback) {
        InterceptResult invokeLLL;
        V8Function v8Function;
        TKJSContext tKJSContext;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(1048593, this, str, str2, javaCallback)) != null) {
            return invokeLLL.objValue;
        }
        if (!TKEnv.isDebug() && ((tKJSContext = this.mTKJSContext) == null || tKJSContext.context() == null)) {
            return null;
        }
        V8Array makeV8Array = this.mTKJSContext.context().makeV8Array();
        try {
            v8Function = new V8Function(this.mTKJSContext.context().getContextRef(), javaCallback);
            try {
                makeV8Array.push(str2);
                makeV8Array.push((V8Value) v8Function);
                return V8ObjectUtils.getValue(this.mV8This.executeFunction(str, makeV8Array));
            } catch (Throwable th) {
                th = th;
                try {
                    TKExceptionDispatcher.reportException(this.mTKJSContext, th);
                    return null;
                } finally {
                    V8Proxy.release(makeV8Array);
                    V8Proxy.release(v8Function);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            v8Function = null;
        }
    }

    public void maybePlayLottieAnimation() {
        LottieTask lottieTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (TextUtils.isEmpty(this.lottieRes)) {
                lottieTask = null;
            } else {
                Context context = getContext();
                lottieTask = LottieCompositionFactory.fromAsset(context, this.lottieRes + ".json");
            }
            if (!TextUtils.isEmpty(this.lottiePath)) {
                if (this.lottiePath.startsWith("http")) {
                    lottieTask = LottieCompositionFactory.fromUrl(getContext(), this.lottiePath);
                } else {
                    try {
                        File file = new File(getRootDir().concat(this.lottiePath));
                        if (file.exists()) {
                            lottieTask = LottieCompositionFactory.fromJsonInputStream(new FileInputStream(file), this.lottiePath);
                        }
                    } catch (Exception e2) {
                        Logger.logE("load lottie from file failed", e2);
                    }
                }
            }
            if (lottieTask != null) {
                lottieTask.addFailureListener(new LottieListener<Throwable>(this) { // from class: com.tachikoma.core.component.TKBase.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TKBase this$0;

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
                        this.this$0 = this;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    public void onResult(Throwable th) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) && TKEnv.isDebug(this.this$0.mTKJSContext)) {
                            PrintStream printStream = System.out;
                            printStream.println("Tachikoma LottieTask Failed. " + Log.getStackTraceString(th));
                        }
                    }
                });
                lottieTask.addListener(new LottieListener<LottieComposition>(this) { // from class: com.tachikoma.core.component.TKBase.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TKBase this$0;

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
                        this.this$0 = this;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    public void onResult(LottieComposition lottieComposition) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, lottieComposition) == null) {
                            this.this$0.maybeSetComposition(lottieComposition);
                        }
                    }
                });
            }
        }
    }

    public void maybeSetComposition(LottieComposition lottieComposition) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, lottieComposition) == null) || lottieComposition == null || getView() == null) {
            return;
        }
        LottieDrawable lottieDrawable = new LottieDrawable();
        lottieDrawable.setComposition(lottieComposition);
        getView().setBackground(lottieDrawable);
    }

    public void onAttach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            maybePlayLottieAnimation();
        }
    }

    @Override // com.tachikoma.core.common.ILifeCycle
    @CallSuper
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }

    @Override // com.tachikoma.core.common.ILifeCycle
    @CallSuper
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            T t = this.mTargetView;
            if (t != null && !(t instanceof ListView)) {
                t.setOnClickListener(null);
                this.mTargetView.setTag(null);
                this.mTargetView = null;
            }
            this.mGestureDetector = null;
            for (Map.Entry<String, V8Function> entry : this.eventListener.entrySet()) {
                V8Proxy.release(entry.getValue());
            }
            this.eventListener.clear();
            V8Object v8Object = this.mV8This;
            if (v8Object != null) {
                v8Object.close();
                this.mV8This = null;
            }
            TKDomNode tKDomNode = this.mNode;
            if (tKDomNode != null) {
                tKDomNode.reset();
                this.mNode = null;
            }
            this.mTKJSContext.context().removeAssociateObject(this);
            destroyAnimation();
            removeAllAnimation();
            this.viewBackgroundManager.destroy();
        }
    }

    public Object onJSInvokeNativeFunctionWithJSONString(String str, String str2, V8Function v8Function) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048599, this, str, str2, v8Function)) == null) {
            IJS2NativeInvoker iJS2NativeInvoker = this.mIJS2NativeInvoker;
            if (iJS2NativeInvoker != null) {
                Object onJSInvokeNativeWithJSONString = iJS2NativeInvoker.onJSInvokeNativeWithJSONString(str, str2, new V8FunctionImpl(v8Function, this.mTKJSContext));
                return onJSInvokeNativeWithJSONString instanceof V8Value ? onJSInvokeNativeWithJSONString : V8ObjectUtils.getV8Result(this.mTKJSContext.context().getContextRef(), onJSInvokeNativeWithJSONString);
            }
            return null;
        }
        return invokeLLL.objValue;
    }

    public void onShadowSet(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048600, this, f2) == null) {
        }
    }

    public void pauseAnimations() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || this.mAnimationMap.isEmpty()) {
            return;
        }
        for (Map.Entry<String, TKBasicAnimation> entry : this.mAnimationMap.entrySet()) {
            if (entry != null && entry.getValue() != null) {
                entry.getValue().pauseAnimation(this);
            }
        }
    }

    public void removeAllAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            Iterator<Map.Entry<String, TKBasicAnimation>> it = this.mAnimationMap.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().stop(this);
                it.remove();
            }
            for (JSContext.V8AssociateReference v8AssociateReference : this.associateAnimationRefList) {
                v8AssociateReference.close();
            }
            this.associateAnimationRefList.clear();
        }
    }

    public void removeAnimation(String str) {
        TKBasicAnimation tKBasicAnimation;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, str) == null) || TextUtils.isEmpty(str) || (tKBasicAnimation = this.mAnimationMap.get(str)) == null) {
            return;
        }
        tKBasicAnimation.stop(this);
        this.mAnimationMap.remove(str);
        JSContext.V8AssociateReference.closeByNative(tKBasicAnimation, this.associateAnimationRefList.iterator());
    }

    public void removeEventListener(String str) {
        V8Function v8Function;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, str) == null) || (v8Function = this.eventListener.get(str)) == null) {
            return;
        }
        V8Proxy.release(v8Function);
        this.eventListener.remove(str);
    }

    public void resumeAnimations() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || this.mAnimationMap.isEmpty()) {
            return;
        }
        for (Map.Entry<String, TKBasicAnimation> entry : this.mAnimationMap.entrySet()) {
            if (entry != null && entry.getValue() != null) {
                entry.getValue().resumeAnimation(this);
            }
        }
    }

    public void setBackgroundColor(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048606, this, obj) == null) && (obj instanceof String)) {
            String str = (String) obj;
            this.mBackgroundColor = str;
            this.viewBackgroundManager.setBackgroundColor(Color.parseColor(TKColorUtil.rgba2argb(str)));
        }
    }

    public void setBackgroundColorInt(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            this.viewBackgroundManager.setBackgroundColor(i2);
        }
    }

    public void setBackgroundImage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            this.viewBackgroundManager.setBackgroundImage(str);
        }
    }

    public void setBorderColor(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            String rgba2argb = TKColorUtil.rgba2argb(str);
            int parseColor = Color.parseColor(rgba2argb);
            this.viewBackgroundManager.setBorderColor(8, parseColor, parseColor >>> 24);
            this.viewBackgroundManager.setBorderColor(rgba2argb);
        }
    }

    public void setBorderRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            float dp2px = TKConverter.dp2px(Tachikoma.sApplication, i2);
            this.mBorderRadius = dp2px;
            this.viewBackgroundManager.setBorderRadius(dp2px);
        }
    }

    public void setBorderStyle(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, str) == null) || str == null) {
            return;
        }
        this.viewBackgroundManager.setBorderStyle(str);
    }

    public void setBorderWidth(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.viewBackgroundManager.setBorderWidth(8, TKConverter.dp2px(Tachikoma.sApplication, (float) d2));
        }
    }

    public void setBottomLeftRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i2) == null) {
            this.viewBackgroundManager.setBorderRadius(TKConverter.dp2px(Tachikoma.sApplication, i2), TKViewBackgroundDrawable.BorderRadiusLocation.BOTTOM_LEFT.ordinal());
        }
    }

    public void setBottomRightRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            this.viewBackgroundManager.setBorderRadius(TKConverter.dp2px(Tachikoma.sApplication, i2), TKViewBackgroundDrawable.BorderRadiusLocation.BOTTOM_RIGHT.ordinal());
        }
    }

    public void setData(Object... objArr) {
        V8Value v8Value;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048615, this, objArr) != null) {
            return;
        }
        V8Object v8Object = this.mV8This;
        V8Array v8Array = null;
        V8Value v8Value2 = null;
        if (v8Object == null || v8Object.isReleased()) {
            if (TKEnv.isDebug(this.mTKJSContext)) {
                throw new IllegalStateException("未找到 TKBase 对应的 js object handler，setData 只对 jsContext.createView 创建的 view 有效");
            }
            Logger.logE("未找到 TKBase 对应的 js object handler，setData 只对 jsContext.createView 创建的 view 有效", null);
            return;
        }
        try {
            V8Array makeV8Array = this.mTKJSContext.context().makeV8Array();
            int i2 = 0;
            while (i2 < objArr.length) {
                try {
                    Object v8Value3 = TKConverter.toV8Value(objArr[i2], this.mTKJSContext.context());
                    makeV8Array.push(v8Value3);
                    i2++;
                    v8Value2 = v8Value3;
                } catch (Throwable th) {
                    th = th;
                    V8Value v8Value4 = v8Value2;
                    v8Array = makeV8Array;
                    v8Value = v8Value4;
                    V8Proxy.release(v8Array);
                    if (v8Value instanceof V8Value) {
                        V8Proxy.release(v8Value);
                    }
                    throw th;
                }
            }
            this.mV8This.executeVoidFunction("setData", makeV8Array);
            V8Proxy.release(makeV8Array);
            if (v8Value2 instanceof V8Value) {
                V8Proxy.release(v8Value2);
            }
        } catch (Throwable th2) {
            th = th2;
            v8Value = null;
        }
    }

    public void setDisplay(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            getView().setVisibility("none".equals(str) ? 8 : 0);
        }
    }

    public void setEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.enabled = z;
            this.mTargetView.setEnabled(z);
        }
    }

    public void setGradientBgColor(String str) {
        String[] split;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048618, this, str) == null) || TextUtils.isEmpty(str) || (split = str.split(",")) == null || split.length < 3) {
            return;
        }
        try {
            int parseInt = Integer.parseInt(split[0].trim());
            int[] iArr = new int[split.length - 1];
            float[] fArr = new float[split.length - 1];
            boolean z = false;
            for (int i2 = 1; i2 < split.length; i2++) {
                String trim = split[i2].trim();
                if (trim.contains(" ")) {
                    String[] split2 = trim.split(" ");
                    int i3 = i2 - 1;
                    iArr[i3] = Color.parseColor(TKColorUtil.rgba2argb(split2[0].trim()));
                    fArr[i3] = Float.parseFloat(split2[1]);
                    z = true;
                } else {
                    iArr[i2 - 1] = Color.parseColor(TKColorUtil.rgba2argb(trim));
                }
            }
            if (z) {
                this.viewBackgroundManager.setBackgroundGradientColor(parseInt, iArr, fArr);
            } else {
                this.viewBackgroundManager.setBackgroundGradientColor(parseInt, iArr, null);
            }
        } catch (Exception unused) {
        }
    }

    public void setIJS2NativeInvoker(IJS2NativeInvoker iJS2NativeInvoker) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, iJS2NativeInvoker) == null) {
            this.mIJS2NativeInvoker = iJS2NativeInvoker;
        }
    }

    public void setOpacity(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{Double.valueOf(d2)}) == null) {
            getView().setAlpha((float) d2);
        }
    }

    public void setRotate(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048621, this, f2) == null) {
            getView().setRotation(f2);
        }
    }

    public void setRotateX(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048622, this, f2) == null) {
            getView().setRotationX(f2);
        }
    }

    public void setRotateY(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048623, this, f2) == null) {
            getView().setRotationY(f2);
        }
    }

    public void setScaleX(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048624, this, f2) == null) {
            getView().setScaleX(f2);
        }
    }

    public void setScaleY(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048625, this, f2) == null) {
            getView().setScaleY(f2);
        }
    }

    public void setShadow(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, str) == null) {
            String[] split = str.split(" ");
            if (split.length != 4) {
                return;
            }
            float[] fArr = new float[3];
            for (int i2 = 0; i2 < 3; i2++) {
                if (split[i2].toLowerCase().contains("px")) {
                    fArr[i2] = Float.parseFloat(split[i2].replace("px", ""));
                } else {
                    fArr[i2] = TKConverter.dp2px(getContext(), Float.parseFloat(split[i2]));
                }
            }
            this.viewBackgroundManager.setShadow(fArr[2], fArr[0], fArr[1], Color.parseColor(TKColorUtil.rgba2argb(split[3])));
            onShadowSet(fArr[2]);
        }
    }

    public void setStyle(HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, hashMap) == null) {
            this.style = hashMap;
            if (this.mTargetView != null) {
                getDomNode().setDomStyle(this.style);
            }
            onStyleUpdated(this.style);
            Object obj = hashMap.get(AnimationProperty.TRANSFORM);
            if (obj instanceof Map) {
                setTransformProperty((Map) obj);
            }
        }
    }

    public void setTKJSContext(TKJSContext tKJSContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, tKJSContext) == null) {
            this.mTKJSContext = tKJSContext;
        }
    }

    public void setTopLeftRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048629, this, i2) == null) {
            this.viewBackgroundManager.setBorderRadius(TKConverter.dp2px(Tachikoma.sApplication, i2), TKViewBackgroundDrawable.BorderRadiusLocation.TOP_LEFT.ordinal());
        }
    }

    public void setTopRightRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i2) == null) {
            this.viewBackgroundManager.setBorderRadius(TKConverter.dp2px(Tachikoma.sApplication, i2), TKViewBackgroundDrawable.BorderRadiusLocation.TOP_RIGHT.ordinal());
        }
    }

    public void setTranslateX(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048631, this, f2) == null) {
            getView().setTranslationX(f2);
        }
    }

    public void setTranslateY(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048632, this, f2) == null) {
            getView().setTranslationY(f2);
        }
    }

    public void setViewID(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, str) == null) {
            this.viewID = str;
            getDomNode().nodeID = str;
        }
    }

    public void setVisibility(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, str) == null) {
            getView().setVisibility(VISIBILITY_HIDDEN.equals(str) ? 4 : 0);
        }
    }

    public void startViewAnimation(String str, long j2, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048635, this, new Object[]{str, Long.valueOf(j2), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            new CustomViewPropertyAnimator(this, str, j2, f2, f3).start();
        }
    }

    public void takeControlOfPaddingSet(HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, hashMap) == null) {
            getView().setPadding(safelyGetPxValue(hashMap, "paddingLeft"), safelyGetPxValue(hashMap, "paddingTop"), safelyGetPxValue(hashMap, "paddingRight"), safelyGetPxValue(hashMap, "paddingBottom"));
            if (hashMap != null) {
                hashMap.remove("paddingLeft");
                hashMap.remove("paddingRight");
                hashMap.remove("paddingTop");
                hashMap.remove("paddingBottom");
            }
        }
    }
}
