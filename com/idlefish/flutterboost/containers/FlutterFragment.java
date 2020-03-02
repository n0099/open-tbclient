package com.idlefish.flutterboost.containers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.containers.BoostFlutterActivity;
import com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate;
import io.flutter.embedding.android.FlutterEngineConfigurator;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.SplashScreen;
import io.flutter.embedding.android.SplashScreenProvider;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class FlutterFragment extends BaseFragment implements FlutterActivityAndFragmentDelegate.Host {
    private FlutterActivityAndFragmentDelegate delegate;
    private boolean isShow;

    @Override // android.support.v4.app.Fragment, com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    @Nullable
    public /* bridge */ /* synthetic */ Activity getActivity() {
        return super.getActivity();
    }

    /* loaded from: classes6.dex */
    public static class NewEngineFragmentBuilder {
        private FlutterShellArgs shellArgs = null;
        private FlutterView.RenderMode renderMode = FlutterView.RenderMode.surface;
        private FlutterView.TransparencyMode transparencyMode = FlutterView.TransparencyMode.transparent;
        private boolean shouldAttachEngineToActivity = true;
        private String url = "";
        private Map params = new HashMap();
        private final Class<? extends FlutterFragment> fragmentClass = FlutterFragment.class;

        public NewEngineFragmentBuilder url(@NonNull String str) {
            this.url = str;
            return this;
        }

        @NonNull
        protected Bundle createArgs() {
            Bundle bundle = new Bundle();
            if (this.shellArgs != null) {
                bundle.putStringArray("initialization_args", this.shellArgs.toArray());
            }
            BoostFlutterActivity.SerializableMap serializableMap = new BoostFlutterActivity.SerializableMap();
            serializableMap.setMap(this.params);
            bundle.putString("url", this.url);
            bundle.putSerializable("params", serializableMap);
            bundle.putString("flutterview_render_mode", this.renderMode != null ? this.renderMode.name() : FlutterView.RenderMode.surface.name());
            bundle.putString("flutterview_transparency_mode", this.transparencyMode != null ? this.transparencyMode.name() : FlutterView.TransparencyMode.transparent.name());
            bundle.putBoolean("destroy_engine_with_fragment", true);
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
                return t;
            } catch (Exception e) {
                throw new RuntimeException("Could not instantiate NewFlutterFragment subclass (" + this.fragmentClass.getName() + ")", e);
            }
        }
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

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return this.delegate.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.delegate.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.isShow) {
            this.isShow = true;
            this.delegate.onResume();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        if (this.isShow) {
            this.delegate.onPrimary(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        this.isShow = false;
        super.onPause();
        this.delegate.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.delegate.onStop();
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

    @Override // android.support.v4.app.Fragment, com.baidu.k.a.a.InterfaceC0078a
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        this.delegate.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.delegate != null) {
            this.delegate.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.delegate.onLowMemory();
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    @NonNull
    public FlutterView.TransparencyMode getTransparencyMode() {
        return FlutterView.TransparencyMode.valueOf(getArguments().getString("flutterview_transparency_mode", FlutterView.TransparencyMode.transparent.name()));
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    @Nullable
    public SplashScreen provideSplashScreen() {
        SplashScreenProvider activity = getActivity();
        if (activity instanceof SplashScreenProvider) {
            return activity.provideSplashScreen();
        }
        return null;
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    @Nullable
    public FlutterEngine provideFlutterEngine(@NonNull Context context) {
        return FlutterBoost.instance().engineProvider();
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    @Nullable
    public PlatformPlugin providePlatformPlugin(@Nullable Activity activity, @NonNull FlutterEngine flutterEngine) {
        if (activity != null) {
            return new PlatformPlugin(getActivity(), flutterEngine.getPlatformChannel());
        }
        return null;
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        FlutterEngineConfigurator activity = getActivity();
        if (activity instanceof FlutterEngineConfigurator) {
            activity.configureFlutterEngine(flutterEngine);
        }
    }

    public void cleanUpFlutterEngine(@NonNull FlutterEngine flutterEngine) {
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    public String getContainerUrl() {
        return getArguments().getString("url");
    }

    @Override // com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    public Map getContainerUrlParams() {
        return ((BoostFlutterActivity.SerializableMap) getArguments().getSerializable("params")).getMap();
    }
}
