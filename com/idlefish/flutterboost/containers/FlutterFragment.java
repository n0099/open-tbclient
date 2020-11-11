package com.idlefish.flutterboost.containers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
/* loaded from: classes12.dex */
public class FlutterFragment extends BaseFragment implements FlutterActivityAndFragmentDelegate.Host {
    protected static final String ARG_APP_BUNDLE_PATH = "app_bundle_path";
    protected static final String ARG_CACHED_ENGINE_ID = "cached_engine_id";
    protected static final String ARG_DART_ENTRYPOINT = "dart_entrypoint";
    protected static final String ARG_DESTROY_ENGINE_WITH_FRAGMENT = "destroy_engine_with_fragment";
    protected static final String ARG_FLUTTERVIEW_RENDER_MODE = "flutterview_render_mode";
    protected static final String ARG_FLUTTERVIEW_TRANSPARENCY_MODE = "flutterview_transparency_mode";
    protected static final String ARG_FLUTTER_INITIALIZATION_ARGS = "initialization_args";
    protected static final String ARG_INITIAL_ROUTE = "initial_route";
    protected static final String ARG_SHOULD_ATTACH_ENGINE_TO_ACTIVITY = "should_attach_engine_to_activity";
    protected static final String EXTRA_PARAMS = "params";
    protected static final String EXTRA_URL = "url";
    private static final String TAG = "NewFlutterFragment";
    private FlutterActivityAndFragmentDelegate delegate;
    private boolean isResumedOrVisibleToUser;
    private boolean sendReumeToDart = false;

    @Override // android.support.v4.app.Fragment, com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    @Nullable
    public /* bridge */ /* synthetic */ Activity getActivity() {
        return super.getActivity();
    }

    @NonNull
    public static FlutterFragment createDefault() {
        return new NewEngineFragmentBuilder().build();
    }

    @NonNull
    public static NewEngineFragmentBuilder withNewEngine() {
        return new NewEngineFragmentBuilder();
    }

    /* loaded from: classes12.dex */
    public static class NewEngineFragmentBuilder {
        private final Class<? extends FlutterFragment> fragmentClass;
        private boolean isUseTabHost;
        private Map params;
        private FlutterView.RenderMode renderMode;
        private FlutterShellArgs shellArgs;
        private boolean shouldAttachEngineToActivity;
        private FlutterView.TransparencyMode transparencyMode;
        private String url;

        public NewEngineFragmentBuilder() {
            this.shellArgs = null;
            this.renderMode = FlutterView.RenderMode.surface;
            this.transparencyMode = FlutterView.TransparencyMode.transparent;
            this.shouldAttachEngineToActivity = true;
            this.url = "";
            this.params = new HashMap();
            this.isUseTabHost = false;
            this.fragmentClass = FlutterFragment.class;
        }

        public NewEngineFragmentBuilder(@NonNull Class<? extends FlutterFragment> cls) {
            this.shellArgs = null;
            this.renderMode = FlutterView.RenderMode.surface;
            this.transparencyMode = FlutterView.TransparencyMode.transparent;
            this.shouldAttachEngineToActivity = true;
            this.url = "";
            this.params = new HashMap();
            this.isUseTabHost = false;
            this.fragmentClass = cls;
        }

        public NewEngineFragmentBuilder url(@NonNull String str) {
            this.url = str;
            return this;
        }

        public NewEngineFragmentBuilder isTabHost(@NonNull boolean z) {
            this.isUseTabHost = z;
            return this;
        }

        @NonNull
        protected Bundle createArgs() {
            Bundle bundle = new Bundle();
            if (this.shellArgs != null) {
                bundle.putStringArray(FlutterFragment.ARG_FLUTTER_INITIALIZATION_ARGS, this.shellArgs.toArray());
            }
            BoostFlutterActivity.SerializableMap serializableMap = new BoostFlutterActivity.SerializableMap();
            serializableMap.setMap(this.params);
            bundle.putString("url", this.url);
            bundle.putSerializable("params", serializableMap);
            bundle.putString(FlutterFragment.ARG_FLUTTERVIEW_RENDER_MODE, this.renderMode != null ? this.renderMode.name() : FlutterView.RenderMode.surface.name());
            bundle.putString(FlutterFragment.ARG_FLUTTERVIEW_TRANSPARENCY_MODE, this.transparencyMode != null ? this.transparencyMode.name() : FlutterView.TransparencyMode.transparent.name());
            bundle.putBoolean(FlutterFragment.ARG_DESTROY_ENGINE_WITH_FRAGMENT, true);
            return bundle;
        }

        @NonNull
        public <T extends FlutterFragment> T build() {
            try {
                T t = (T) this.fragmentClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                if (t == null) {
                    throw new RuntimeException("The NewFlutterFragment subclass sent in the constructor (" + this.fragmentClass.getCanonicalName() + ") does not match the expected return type.");
                }
                t.setArguments(createArgs());
                t.sendReumeToDart(this.isUseTabHost ? false : true);
                return t;
            } catch (Exception e) {
                throw new RuntimeException("Could not instantiate NewFlutterFragment subclass (" + this.fragmentClass.getName() + ")", e);
            }
        }
    }

    protected XFlutterView getFlutterView() {
        return this.delegate.getFlutterView();
    }

    public FlutterFragment() {
        setArguments(new Bundle());
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.delegate = new FlutterActivityAndFragmentDelegate(this);
        this.delegate.onAttach(context);
    }

    public void sendReumeToDart(@NonNull boolean z) {
        this.sendReumeToDart = z;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return this.delegate.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (!isHidden()) {
            this.delegate.onStart();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!isHidden() && this.sendReumeToDart && !this.isResumedOrVisibleToUser) {
            this.isResumedOrVisibleToUser = true;
            this.delegate.onResume();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        if (this.delegate != null) {
            if (z) {
                if (!this.isResumedOrVisibleToUser) {
                    this.sendReumeToDart = true;
                    this.isResumedOrVisibleToUser = true;
                    this.delegate.onResume();
                }
            } else if (this.isResumedOrVisibleToUser) {
                this.sendReumeToDart = false;
                this.isResumedOrVisibleToUser = false;
                this.delegate.onPause();
            }
            if (FlutterLifeCycleBugEnableSwitch.isOn() && TbadkCoreApplication.getInst().isInBackground()) {
                this.sendReumeToDart = z;
                this.isResumedOrVisibleToUser = z;
            }
        }
    }

    public void onPostResume() {
        this.delegate.onPostResume();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (!isHidden() && this.sendReumeToDart && this.isResumedOrVisibleToUser) {
            this.isResumedOrVisibleToUser = false;
            this.delegate.onPause();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (!isHidden()) {
            this.delegate.onStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.delegate.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.delegate.onDetach();
        this.delegate.release();
        this.delegate = null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z) {
            this.delegate.onPause();
        } else {
            this.delegate.onResume();
        }
    }

    @Override // android.support.v4.app.Fragment, com.baidu.m.a.a.InterfaceC0250a
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        this.delegate.onRequestPermissionsResult(i, strArr, iArr);
    }

    public void onNewIntent(@NonNull Intent intent) {
        this.delegate.onNewIntent(intent);
    }

    public void onBackPressed() {
        this.delegate.onBackPressed();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.delegate != null) {
            this.delegate.onActivityResult(i, i2, intent);
        }
    }

    public void onUserLeaveHint() {
        this.delegate.onUserLeaveHint();
    }

    public void onTrimMemory(int i) {
        this.delegate.onTrimMemory(i);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.delegate.onLowMemory();
    }

    @NonNull
    private Context getContextCompat() {
        return Build.VERSION.SDK_INT >= 23 ? getContext() : getActivity();
    }

    @NonNull
    public FlutterShellArgs getFlutterShellArgs() {
        String[] stringArray = getArguments().getStringArray(ARG_FLUTTER_INITIALIZATION_ARGS);
        if (stringArray == null) {
            stringArray = new String[0];
        }
        return new FlutterShellArgs(stringArray);
    }

    @NonNull
    public FlutterView.RenderMode getRenderMode() {
        return FlutterView.RenderMode.valueOf(getArguments().getString(ARG_FLUTTERVIEW_RENDER_MODE, FlutterView.RenderMode.surface.name()));
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    @NonNull
    public FlutterView.TransparencyMode getTransparencyMode() {
        return FlutterView.TransparencyMode.valueOf(getArguments().getString(ARG_FLUTTERVIEW_TRANSPARENCY_MODE, FlutterView.TransparencyMode.transparent.name()));
    }

    @Nullable
    public SplashScreen provideSplashScreen() {
        FragmentActivity activity = getActivity();
        if (activity instanceof SplashScreenProvider) {
            return ((SplashScreenProvider) activity).provideSplashScreen();
        }
        return null;
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host, io.flutter.embedding.android.FlutterEngineProvider
    @Nullable
    public FlutterEngine provideFlutterEngine(@NonNull Context context) {
        return FlutterBoost.instance().engineProvider();
    }

    @Nullable
    public FlutterEngine getFlutterEngine() {
        return this.delegate.getFlutterEngine();
    }

    public FlutterActivityAndFragmentDelegate getFlutterDelegate() {
        return this.delegate;
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    @Nullable
    public XPlatformPlugin providePlatformPlugin(@NonNull FlutterEngine flutterEngine) {
        return BoostViewUtils.getPlatformPlugin(flutterEngine.getPlatformChannel());
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host, io.flutter.embedding.android.FlutterEngineConfigurator
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        FragmentActivity activity = getActivity();
        if (activity instanceof FlutterEngineConfigurator) {
            ((FlutterEngineConfigurator) activity).configureFlutterEngine(flutterEngine);
        }
    }

    @Override // io.flutter.embedding.android.FlutterEngineConfigurator
    public void cleanUpFlutterEngine(@NonNull FlutterEngine flutterEngine) {
    }

    public boolean shouldAttachEngineToActivity() {
        return true;
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    public String getContainerUrl() {
        return getArguments().getString("url");
    }

    public Map getContainerUrlParams() {
        return ((BoostFlutterActivity.SerializableMap) getArguments().getSerializable("params")).getMap();
    }

    public void setSwipeBackEnable(boolean z) {
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    public void swipeBackControl(double d) {
    }
}
