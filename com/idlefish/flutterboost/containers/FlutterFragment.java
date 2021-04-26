package com.idlefish.flutterboost.containers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.switchs.FlutterLifeCycleBugEnableSwitch;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.XFlutterView;
import com.idlefish.flutterboost.XPlatformPlugin;
import com.idlefish.flutterboost.containers.BoostFlutterActivity;
import com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate;
import io.flutter.embedding.android.FlutterEngineConfigurator;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.SplashScreen;
import io.flutter.embedding.android.SplashScreenProvider;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class FlutterFragment extends BaseFragment implements FlutterActivityAndFragmentDelegate.Host {
    public static final String ARG_APP_BUNDLE_PATH = "app_bundle_path";
    public static final String ARG_CACHED_ENGINE_ID = "cached_engine_id";
    public static final String ARG_DART_ENTRYPOINT = "dart_entrypoint";
    public static final String ARG_DESTROY_ENGINE_WITH_FRAGMENT = "destroy_engine_with_fragment";
    public static final String ARG_FLUTTERVIEW_RENDER_MODE = "flutterview_render_mode";
    public static final String ARG_FLUTTERVIEW_TRANSPARENCY_MODE = "flutterview_transparency_mode";
    public static final String ARG_FLUTTER_INITIALIZATION_ARGS = "initialization_args";
    public static final String ARG_INITIAL_ROUTE = "initial_route";
    public static final String ARG_SHOULD_ATTACH_ENGINE_TO_ACTIVITY = "should_attach_engine_to_activity";
    public static final String EXTRA_PARAMS = "params";
    public static final String EXTRA_URL = "url";
    public static final String TAG = "NewFlutterFragment";
    public FlutterActivityAndFragmentDelegate delegate;
    public boolean isResumedOrVisibleToUser;
    public boolean sendReumeToDart = false;

    public FlutterFragment() {
        setArguments(new Bundle());
    }

    @NonNull
    public static FlutterFragment createDefault() {
        return new NewEngineFragmentBuilder().build();
    }

    @NonNull
    private Context getContextCompat() {
        if (Build.VERSION.SDK_INT >= 23) {
            return getContext();
        }
        return getActivity();
    }

    @NonNull
    public static NewEngineFragmentBuilder withNewEngine() {
        return new NewEngineFragmentBuilder();
    }

    @Override // io.flutter.embedding.android.FlutterEngineConfigurator
    public void cleanUpFlutterEngine(@NonNull FlutterEngine flutterEngine) {
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host, io.flutter.embedding.android.FlutterEngineConfigurator
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        FragmentActivity activity = getActivity();
        if (activity instanceof FlutterEngineConfigurator) {
            ((FlutterEngineConfigurator) activity).configureFlutterEngine(flutterEngine);
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.wallet.lightapp.multipage.a
    @Nullable
    public /* bridge */ /* synthetic */ Activity getActivity() {
        return super.getActivity();
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    public String getContainerUrl() {
        return getArguments().getString("url");
    }

    public Map<String, Object> getContainerUrlParams() {
        return ((BoostFlutterActivity.SerializableMap) getArguments().getSerializable("params")).getMap();
    }

    public FlutterActivityAndFragmentDelegate getFlutterDelegate() {
        return this.delegate;
    }

    @Nullable
    public FlutterEngine getFlutterEngine() {
        return this.delegate.getFlutterEngine();
    }

    @NonNull
    public FlutterShellArgs getFlutterShellArgs() {
        String[] stringArray = getArguments().getStringArray("initialization_args");
        if (stringArray == null) {
            stringArray = new String[0];
        }
        return new FlutterShellArgs(stringArray);
    }

    public XFlutterView getFlutterView() {
        return this.delegate.getFlutterView();
    }

    @NonNull
    public FlutterView.RenderMode getRenderMode() {
        return FlutterView.RenderMode.valueOf(getArguments().getString("flutterview_render_mode", FlutterView.RenderMode.surface.name()));
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    @NonNull
    public FlutterView.TransparencyMode getTransparencyMode() {
        return FlutterView.TransparencyMode.valueOf(getArguments().getString("flutterview_transparency_mode", FlutterView.TransparencyMode.transparent.name()));
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        FlutterActivityAndFragmentDelegate flutterActivityAndFragmentDelegate = this.delegate;
        if (flutterActivityAndFragmentDelegate != null) {
            flutterActivityAndFragmentDelegate.onActivityResult(i2, i3, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        FlutterActivityAndFragmentDelegate flutterActivityAndFragmentDelegate = new FlutterActivityAndFragmentDelegate(this);
        this.delegate = flutterActivityAndFragmentDelegate;
        flutterActivityAndFragmentDelegate.onAttach(context);
    }

    public void onBackPressed() {
        this.delegate.onBackPressed();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return this.delegate.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.delegate.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.delegate.onDetach();
        this.delegate.release();
        this.delegate = null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z) {
            this.delegate.onPause();
        } else {
            this.delegate.onResume();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.delegate.onLowMemory();
    }

    public void onNewIntent(@NonNull Intent intent) {
        this.delegate.onNewIntent(intent);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (!isHidden() && this.sendReumeToDart && this.isResumedOrVisibleToUser) {
            this.isResumedOrVisibleToUser = false;
            this.delegate.onPause();
        }
    }

    public void onPostResume() {
        this.delegate.onPostResume();
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        this.delegate.onRequestPermissionsResult(i2, strArr, iArr);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (isHidden() || !this.sendReumeToDart || this.isResumedOrVisibleToUser) {
            return;
        }
        this.isResumedOrVisibleToUser = true;
        this.delegate.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (isHidden()) {
            return;
        }
        this.delegate.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (isHidden()) {
            return;
        }
        this.delegate.onStop();
    }

    public void onTrimMemory(int i2) {
        this.delegate.onTrimMemory(i2);
    }

    public void onUserLeaveHint() {
        this.delegate.onUserLeaveHint();
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host, io.flutter.embedding.android.FlutterEngineProvider
    @Nullable
    public FlutterEngine provideFlutterEngine(@NonNull Context context) {
        return FlutterBoost.instance().engineProvider();
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    @Nullable
    public XPlatformPlugin providePlatformPlugin(@NonNull FlutterEngine flutterEngine) {
        return BoostViewUtils.getPlatformPlugin(flutterEngine.getPlatformChannel());
    }

    @Nullable
    public SplashScreen provideSplashScreen() {
        FragmentActivity activity = getActivity();
        if (activity instanceof SplashScreenProvider) {
            return ((SplashScreenProvider) activity).provideSplashScreen();
        }
        return null;
    }

    public void sendReumeToDart(@NonNull boolean z) {
        this.sendReumeToDart = z;
    }

    public void setSwipeBackEnable(boolean z) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        FlutterActivityAndFragmentDelegate flutterActivityAndFragmentDelegate = this.delegate;
        if (flutterActivityAndFragmentDelegate == null) {
            return;
        }
        if (z) {
            if (!this.isResumedOrVisibleToUser) {
                this.sendReumeToDart = true;
                this.isResumedOrVisibleToUser = true;
                flutterActivityAndFragmentDelegate.onResume();
            }
        } else if (this.isResumedOrVisibleToUser) {
            this.sendReumeToDart = false;
            this.isResumedOrVisibleToUser = false;
            flutterActivityAndFragmentDelegate.onPause();
        }
        if (FlutterLifeCycleBugEnableSwitch.isOn()) {
            this.sendReumeToDart = z;
            this.isResumedOrVisibleToUser = z;
        }
    }

    public boolean shouldAttachEngineToActivity() {
        return true;
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    public void swipeBackControl(double d2) {
    }

    /* loaded from: classes6.dex */
    public static class NewEngineFragmentBuilder {
        public final Class<? extends FlutterFragment> fragmentClass;
        public boolean isUseTabHost;
        public Map params;
        public FlutterView.RenderMode renderMode;
        public FlutterShellArgs shellArgs;
        public FlutterView.TransparencyMode transparencyMode;
        public String url;

        public NewEngineFragmentBuilder() {
            this.shellArgs = null;
            this.renderMode = FlutterView.RenderMode.surface;
            this.transparencyMode = FlutterView.TransparencyMode.transparent;
            this.url = "";
            this.params = new HashMap();
            this.isUseTabHost = false;
            this.fragmentClass = FlutterFragment.class;
        }

        @NonNull
        public <T extends FlutterFragment> T build() {
            try {
                T t = (T) this.fragmentClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                if (t != null) {
                    t.setArguments(createArgs());
                    t.sendReumeToDart(this.isUseTabHost ? false : true);
                    return t;
                }
                throw new RuntimeException("The NewFlutterFragment subclass sent in the constructor (" + this.fragmentClass.getCanonicalName() + ") does not match the expected return type.");
            } catch (Exception e2) {
                throw new RuntimeException("Could not instantiate NewFlutterFragment subclass (" + this.fragmentClass.getName() + SmallTailInfo.EMOTION_SUFFIX, e2);
            }
        }

        @NonNull
        public Bundle createArgs() {
            Bundle bundle = new Bundle();
            FlutterShellArgs flutterShellArgs = this.shellArgs;
            if (flutterShellArgs != null) {
                bundle.putStringArray("initialization_args", flutterShellArgs.toArray());
            }
            BoostFlutterActivity.SerializableMap serializableMap = new BoostFlutterActivity.SerializableMap();
            serializableMap.setMap(this.params);
            bundle.putString("url", this.url);
            bundle.putSerializable("params", serializableMap);
            FlutterView.RenderMode renderMode = this.renderMode;
            if (renderMode == null) {
                renderMode = FlutterView.RenderMode.surface;
            }
            bundle.putString("flutterview_render_mode", renderMode.name());
            FlutterView.TransparencyMode transparencyMode = this.transparencyMode;
            if (transparencyMode == null) {
                transparencyMode = FlutterView.TransparencyMode.transparent;
            }
            bundle.putString("flutterview_transparency_mode", transparencyMode.name());
            bundle.putBoolean("destroy_engine_with_fragment", true);
            return bundle;
        }

        public NewEngineFragmentBuilder isTabHost(@NonNull boolean z) {
            this.isUseTabHost = z;
            return this;
        }

        public NewEngineFragmentBuilder params(@NonNull Map map) {
            this.params = map;
            return this;
        }

        public NewEngineFragmentBuilder url(@NonNull String str) {
            this.url = str;
            return this;
        }

        public NewEngineFragmentBuilder(@NonNull Class<? extends FlutterFragment> cls) {
            this.shellArgs = null;
            this.renderMode = FlutterView.RenderMode.surface;
            this.transparencyMode = FlutterView.TransparencyMode.transparent;
            this.url = "";
            this.params = new HashMap();
            this.isUseTabHost = false;
            this.fragmentClass = cls;
        }
    }
}
