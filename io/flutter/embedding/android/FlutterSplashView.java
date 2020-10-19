package io.flutter.embedding.android;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.Log;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
/* loaded from: classes7.dex */
final class FlutterSplashView extends FrameLayout {
    private static String TAG = "FlutterSplashView";
    @NonNull
    private final FlutterView.FlutterEngineAttachmentListener flutterEngineAttachmentListener;
    @NonNull
    private final FlutterUiDisplayListener flutterUiDisplayListener;
    @Nullable
    private FlutterView flutterView;
    @NonNull
    private final Runnable onTransitionComplete;
    @Nullable
    private String previousCompletedSplashIsolate;
    @Nullable
    private SplashScreen splashScreen;
    @Nullable
    private Bundle splashScreenState;
    @Nullable
    private View splashScreenView;
    @Nullable
    private String transitioningIsolateId;

    public FlutterSplashView(@NonNull Context context) {
        this(context, null, 0);
    }

    public FlutterSplashView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlutterSplashView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.flutterEngineAttachmentListener = new FlutterView.FlutterEngineAttachmentListener() { // from class: io.flutter.embedding.android.FlutterSplashView.1
            @Override // io.flutter.embedding.android.FlutterView.FlutterEngineAttachmentListener
            public void onFlutterEngineAttachedToFlutterView(@NonNull FlutterEngine flutterEngine) {
                FlutterSplashView.this.flutterView.removeFlutterEngineAttachmentListener(this);
                FlutterSplashView.this.displayFlutterViewWithSplash(FlutterSplashView.this.flutterView, FlutterSplashView.this.splashScreen);
            }

            @Override // io.flutter.embedding.android.FlutterView.FlutterEngineAttachmentListener
            public void onFlutterEngineDetachedFromFlutterView() {
            }
        };
        this.flutterUiDisplayListener = new FlutterUiDisplayListener() { // from class: io.flutter.embedding.android.FlutterSplashView.2
            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiDisplayed() {
                if (FlutterSplashView.this.splashScreen != null) {
                    FlutterSplashView.this.transitionToFlutter();
                }
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiNoLongerDisplayed() {
            }
        };
        this.onTransitionComplete = new Runnable() { // from class: io.flutter.embedding.android.FlutterSplashView.3
            @Override // java.lang.Runnable
            public void run() {
                FlutterSplashView.this.removeView(FlutterSplashView.this.splashScreenView);
                FlutterSplashView.this.previousCompletedSplashIsolate = FlutterSplashView.this.transitioningIsolateId;
            }
        };
        setSaveEnabled(true);
    }

    @Override // android.view.View
    @Nullable
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.previousCompletedSplashIsolate = this.previousCompletedSplashIsolate;
        savedState.splashScreenState = this.splashScreen != null ? this.splashScreen.saveSplashScreenState() : null;
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.previousCompletedSplashIsolate = savedState.previousCompletedSplashIsolate;
        this.splashScreenState = savedState.splashScreenState;
    }

    public void displayFlutterViewWithSplash(@NonNull FlutterView flutterView, @Nullable SplashScreen splashScreen) {
        if (this.flutterView != null) {
            this.flutterView.removeOnFirstFrameRenderedListener(this.flutterUiDisplayListener);
            removeView(this.flutterView);
        }
        if (this.splashScreenView != null) {
            removeView(this.splashScreenView);
        }
        this.flutterView = flutterView;
        addView(flutterView);
        this.splashScreen = splashScreen;
        if (splashScreen != null) {
            if (isSplashScreenNeededNow()) {
                Log.v(TAG, "Showing splash screen UI.");
                this.splashScreenView = splashScreen.createSplashView(getContext(), this.splashScreenState);
                addView(this.splashScreenView);
                flutterView.addOnFirstFrameRenderedListener(this.flutterUiDisplayListener);
            } else if (isSplashScreenTransitionNeededNow()) {
                Log.v(TAG, "Showing an immediate splash transition to Flutter due to previously interrupted transition.");
                this.splashScreenView = splashScreen.createSplashView(getContext(), this.splashScreenState);
                addView(this.splashScreenView);
                transitionToFlutter();
            } else if (!flutterView.isAttachedToFlutterEngine()) {
                Log.v(TAG, "FlutterView is not yet attached to a FlutterEngine. Showing nothing until a FlutterEngine is attached.");
                flutterView.addFlutterEngineAttachmentListener(this.flutterEngineAttachmentListener);
            }
        }
    }

    private boolean isSplashScreenNeededNow() {
        return (this.flutterView == null || !this.flutterView.isAttachedToFlutterEngine() || this.flutterView.hasRenderedFirstFrame() || hasSplashCompleted()) ? false : true;
    }

    private boolean isSplashScreenTransitionNeededNow() {
        return this.flutterView != null && this.flutterView.isAttachedToFlutterEngine() && this.splashScreen != null && this.splashScreen.doesSplashViewRememberItsTransition() && wasPreviousSplashTransitionInterrupted();
    }

    private boolean wasPreviousSplashTransitionInterrupted() {
        if (this.flutterView == null) {
            throw new IllegalStateException("Cannot determine if previous splash transition was interrupted when no FlutterView is set.");
        }
        if (this.flutterView.isAttachedToFlutterEngine()) {
            return this.flutterView.hasRenderedFirstFrame() && !hasSplashCompleted();
        }
        throw new IllegalStateException("Cannot determine if previous splash transition was interrupted when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
    }

    private boolean hasSplashCompleted() {
        if (this.flutterView == null) {
            throw new IllegalStateException("Cannot determine if splash has completed when no FlutterView is set.");
        }
        if (this.flutterView.isAttachedToFlutterEngine()) {
            return this.flutterView.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId() != null && this.flutterView.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId().equals(this.previousCompletedSplashIsolate);
        }
        throw new IllegalStateException("Cannot determine if splash has completed when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void transitionToFlutter() {
        this.transitioningIsolateId = this.flutterView.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId();
        Log.v(TAG, "Transitioning splash screen to a Flutter UI. Isolate: " + this.transitioningIsolateId);
        this.splashScreen.transitionToFlutter(this.onTransitionComplete);
    }

    @Keep
    /* loaded from: classes7.dex */
    public static class SavedState extends View.BaseSavedState {
        public static Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: io.flutter.embedding.android.FlutterSplashView.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        private String previousCompletedSplashIsolate;
        private Bundle splashScreenState;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.previousCompletedSplashIsolate = parcel.readString();
            this.splashScreenState = parcel.readBundle(getClass().getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.previousCompletedSplashIsolate);
            parcel.writeBundle(this.splashScreenState);
        }
    }
}
