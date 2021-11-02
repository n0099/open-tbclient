package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
/* loaded from: classes11.dex */
public class BottomNavigationView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEF_STYLE_RES;
    public static final int MENU_PRESENTER_ID = 1;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public ColorStateList itemRippleColor;
    @NonNull
    public final MenuBuilder menu;
    public MenuInflater menuInflater;
    @NonNull
    @VisibleForTesting
    public final BottomNavigationMenuView menuView;
    public final BottomNavigationPresenter presenter;
    public OnNavigationItemReselectedListener reselectedListener;
    public OnNavigationItemSelectedListener selectedListener;

    /* loaded from: classes11.dex */
    public interface OnNavigationItemReselectedListener {
        void onNavigationItemReselected(@NonNull MenuItem menuItem);
    }

    /* loaded from: classes11.dex */
    public interface OnNavigationItemSelectedListener {
        boolean onNavigationItemSelected(@NonNull MenuItem menuItem);
    }

    /* loaded from: classes11.dex */
    public static class SavedState extends AbsSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public Bundle menuPresenterState;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1826741877, "Lcom/google/android/material/bottomnavigation/BottomNavigationView$SavedState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1826741877, "Lcom/google/android/material/bottomnavigation/BottomNavigationView$SavedState;");
                    return;
                }
            }
            CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.bottomnavigation.BottomNavigationView.SavedState.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                @NonNull
                public SavedState[] newArray(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(1048580, this, i2)) == null) ? new SavedState[i2] : (SavedState[]) invokeI.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.ClassLoaderCreator
                @NonNull
                public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, classLoader)) == null) ? new SavedState(parcel, classLoader) : (SavedState) invokeLL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                @Nullable
                public SavedState createFromParcel(@NonNull Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new SavedState(parcel, null) : (SavedState) invokeL.objValue;
                }
            };
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcelable parcelable) {
            super(parcelable);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcelable};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Parcelable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }

        private void readFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65539, this, parcel, classLoader) == null) {
                this.menuPresenterState = parcel.readBundle(classLoader);
            }
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i2) == null) {
                super.writeToParcel(parcel, i2);
                parcel.writeBundle(this.menuPresenterState);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel, classLoader};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Parcel) objArr2[0], (ClassLoader) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            readFromParcel(parcel, classLoader == null ? SavedState.class.getClassLoader() : classLoader);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-843880653, "Lcom/google/android/material/bottomnavigation/BottomNavigationView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-843880653, "Lcom/google/android/material/bottomnavigation/BottomNavigationView;");
                return;
            }
        }
        DEF_STYLE_RES = R.style.Widget_Design_BottomNavigationView;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BottomNavigationView(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void addCompatibilityTopDivider(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, context) == null) {
            View view = new View(context);
            view.setBackgroundColor(ContextCompat.getColor(context, R.color.design_bottom_navigation_shadow_color));
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_shadow_height)));
            addView(view);
        }
    }

    private void applyWindowInsets() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            ViewUtils.doOnApplyWindowInsets(this, new ViewUtils.OnApplyWindowInsetsListener(this) { // from class: com.google.android.material.bottomnavigation.BottomNavigationView.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BottomNavigationView this$0;

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

                @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
                @NonNull
                public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull ViewUtils.RelativePadding relativePadding) {
                    InterceptResult invokeLLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048576, this, view, windowInsetsCompat, relativePadding)) == null) {
                        relativePadding.bottom += windowInsetsCompat.getSystemWindowInsetBottom();
                        relativePadding.applyToView(view);
                        return windowInsetsCompat;
                    }
                    return (WindowInsetsCompat) invokeLLL.objValue;
                }
            });
        }
    }

    @NonNull
    private MaterialShapeDrawable createMaterialShapeDrawableBackground(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, context)) == null) {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            Drawable background = getBackground();
            if (background instanceof ColorDrawable) {
                materialShapeDrawable.setFillColor(ColorStateList.valueOf(((ColorDrawable) background).getColor()));
            }
            materialShapeDrawable.initializeElevationOverlay(context);
            return materialShapeDrawable;
        }
        return (MaterialShapeDrawable) invokeL.objValue;
    }

    private MenuInflater getMenuInflater() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            if (this.menuInflater == null) {
                this.menuInflater = new SupportMenuInflater(getContext());
            }
            return this.menuInflater;
        }
        return (MenuInflater) invokeV.objValue;
    }

    @Nullable
    public BadgeDrawable getBadge(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.menuView.getBadge(i2) : (BadgeDrawable) invokeI.objValue;
    }

    @Nullable
    public Drawable getItemBackground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.menuView.getItemBackground() : (Drawable) invokeV.objValue;
    }

    @DrawableRes
    @Deprecated
    public int getItemBackgroundResource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.menuView.getItemBackgroundRes() : invokeV.intValue;
    }

    @Dimension
    public int getItemIconSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.menuView.getItemIconSize() : invokeV.intValue;
    }

    @Nullable
    public ColorStateList getItemIconTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.menuView.getIconTintList() : (ColorStateList) invokeV.objValue;
    }

    @Nullable
    public ColorStateList getItemRippleColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.itemRippleColor : (ColorStateList) invokeV.objValue;
    }

    @StyleRes
    public int getItemTextAppearanceActive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.menuView.getItemTextAppearanceActive() : invokeV.intValue;
    }

    @StyleRes
    public int getItemTextAppearanceInactive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.menuView.getItemTextAppearanceInactive() : invokeV.intValue;
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.menuView.getItemTextColor() : (ColorStateList) invokeV.objValue;
    }

    public int getLabelVisibilityMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.menuView.getLabelVisibilityMode() : invokeV.intValue;
    }

    public int getMaxItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return 5;
        }
        return invokeV.intValue;
    }

    @NonNull
    public Menu getMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.menu : (Menu) invokeV.objValue;
    }

    public BadgeDrawable getOrCreateBadge(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) ? this.menuView.getOrCreateBadge(i2) : (BadgeDrawable) invokeI.objValue;
    }

    @IdRes
    public int getSelectedItemId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.menuView.getSelectedItemId() : invokeV.intValue;
    }

    public void inflateMenu(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.presenter.setUpdateSuspended(true);
            getMenuInflater().inflate(i2, this.menu);
            this.presenter.setUpdateSuspended(false);
            this.presenter.updateMenuView(true);
        }
    }

    public boolean isItemHorizontalTranslationEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.menuView.isItemHorizontalTranslationEnabled() : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onAttachedToWindow();
            MaterialShapeUtils.setParentAbsoluteElevation(this);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, parcelable) == null) {
            if (!(parcelable instanceof SavedState)) {
                super.onRestoreInstanceState(parcelable);
                return;
            }
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.menu.restorePresenterStates(savedState.menuPresenterState);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            SavedState savedState = new SavedState(super.onSaveInstanceState());
            Bundle bundle = new Bundle();
            savedState.menuPresenterState = bundle;
            this.menu.savePresenterStates(bundle);
            return savedState;
        }
        return (Parcelable) invokeV.objValue;
    }

    public void removeBadge(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.menuView.removeBadge(i2);
        }
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048596, this, f2) == null) {
            super.setElevation(f2);
            MaterialShapeUtils.setElevation(this, f2);
        }
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, drawable) == null) {
            this.menuView.setItemBackground(drawable);
            this.itemRippleColor = null;
        }
    }

    public void setItemBackgroundResource(@DrawableRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.menuView.setItemBackgroundRes(i2);
            this.itemRippleColor = null;
        }
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048599, this, z) == null) || this.menuView.isItemHorizontalTranslationEnabled() == z) {
            return;
        }
        this.menuView.setItemHorizontalTranslationEnabled(z);
        this.presenter.updateMenuView(false);
    }

    public void setItemIconSize(@Dimension int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.menuView.setItemIconSize(i2);
        }
    }

    public void setItemIconSizeRes(@DimenRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            setItemIconSize(getResources().getDimensionPixelSize(i2));
        }
    }

    public void setItemIconTintList(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, colorStateList) == null) {
            this.menuView.setIconTintList(colorStateList);
        }
    }

    public void setItemRippleColor(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, colorStateList) == null) {
            if (this.itemRippleColor == colorStateList) {
                if (colorStateList != null || this.menuView.getItemBackground() == null) {
                    return;
                }
                this.menuView.setItemBackground(null);
                return;
            }
            this.itemRippleColor = colorStateList;
            if (colorStateList == null) {
                this.menuView.setItemBackground(null);
                return;
            }
            ColorStateList convertToRippleDrawableColor = RippleUtils.convertToRippleDrawableColor(colorStateList);
            if (Build.VERSION.SDK_INT >= 21) {
                this.menuView.setItemBackground(new RippleDrawable(convertToRippleDrawableColor, null, null));
                return;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(1.0E-5f);
            Drawable wrap = DrawableCompat.wrap(gradientDrawable);
            DrawableCompat.setTintList(wrap, convertToRippleDrawableColor);
            this.menuView.setItemBackground(wrap);
        }
    }

    public void setItemTextAppearanceActive(@StyleRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.menuView.setItemTextAppearanceActive(i2);
        }
    }

    public void setItemTextAppearanceInactive(@StyleRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            this.menuView.setItemTextAppearanceInactive(i2);
        }
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, colorStateList) == null) {
            this.menuView.setItemTextColor(colorStateList);
        }
    }

    public void setLabelVisibilityMode(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048607, this, i2) == null) || this.menuView.getLabelVisibilityMode() == i2) {
            return;
        }
        this.menuView.setLabelVisibilityMode(i2);
        this.presenter.updateMenuView(false);
    }

    public void setOnNavigationItemReselectedListener(@Nullable OnNavigationItemReselectedListener onNavigationItemReselectedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, onNavigationItemReselectedListener) == null) {
            this.reselectedListener = onNavigationItemReselectedListener;
        }
    }

    public void setOnNavigationItemSelectedListener(@Nullable OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, onNavigationItemSelectedListener) == null) {
            this.selectedListener = onNavigationItemSelectedListener;
        }
    }

    public void setSelectedItemId(@IdRes int i2) {
        MenuItem findItem;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048610, this, i2) == null) || (findItem = this.menu.findItem(i2)) == null || this.menu.performItemAction(findItem, this.presenter, 0)) {
            return;
        }
        findItem.setChecked(true);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BottomNavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomNavigationStyle);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomNavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i2, DEF_STYLE_RES), attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.presenter = new BottomNavigationPresenter();
        Context context2 = getContext();
        this.menu = new BottomNavigationMenu(context2);
        this.menuView = new BottomNavigationMenuView(context2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.menuView.setLayoutParams(layoutParams);
        this.presenter.setBottomNavigationMenuView(this.menuView);
        this.presenter.setId(1);
        this.menuView.setPresenter(this.presenter);
        this.menu.addMenuPresenter(this.presenter);
        this.presenter.initForMenu(getContext(), this.menu);
        TintTypedArray obtainTintedStyledAttributes = ThemeEnforcement.obtainTintedStyledAttributes(context2, attributeSet, R.styleable.BottomNavigationView, i2, R.style.Widget_Design_BottomNavigationView, R.styleable.BottomNavigationView_itemTextAppearanceInactive, R.styleable.BottomNavigationView_itemTextAppearanceActive);
        if (obtainTintedStyledAttributes.hasValue(R.styleable.BottomNavigationView_itemIconTint)) {
            this.menuView.setIconTintList(obtainTintedStyledAttributes.getColorStateList(R.styleable.BottomNavigationView_itemIconTint));
        } else {
            BottomNavigationMenuView bottomNavigationMenuView = this.menuView;
            bottomNavigationMenuView.setIconTintList(bottomNavigationMenuView.createDefaultColorStateList(16842808));
        }
        setItemIconSize(obtainTintedStyledAttributes.getDimensionPixelSize(R.styleable.BottomNavigationView_itemIconSize, getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_icon_size)));
        if (obtainTintedStyledAttributes.hasValue(R.styleable.BottomNavigationView_itemTextAppearanceInactive)) {
            setItemTextAppearanceInactive(obtainTintedStyledAttributes.getResourceId(R.styleable.BottomNavigationView_itemTextAppearanceInactive, 0));
        }
        if (obtainTintedStyledAttributes.hasValue(R.styleable.BottomNavigationView_itemTextAppearanceActive)) {
            setItemTextAppearanceActive(obtainTintedStyledAttributes.getResourceId(R.styleable.BottomNavigationView_itemTextAppearanceActive, 0));
        }
        if (obtainTintedStyledAttributes.hasValue(R.styleable.BottomNavigationView_itemTextColor)) {
            setItemTextColor(obtainTintedStyledAttributes.getColorStateList(R.styleable.BottomNavigationView_itemTextColor));
        }
        if (getBackground() == null || (getBackground() instanceof ColorDrawable)) {
            ViewCompat.setBackground(this, createMaterialShapeDrawableBackground(context2));
        }
        if (obtainTintedStyledAttributes.hasValue(R.styleable.BottomNavigationView_elevation)) {
            ViewCompat.setElevation(this, obtainTintedStyledAttributes.getDimensionPixelSize(R.styleable.BottomNavigationView_elevation, 0));
        }
        DrawableCompat.setTintList(getBackground().mutate(), MaterialResources.getColorStateList(context2, obtainTintedStyledAttributes, R.styleable.BottomNavigationView_backgroundTint));
        setLabelVisibilityMode(obtainTintedStyledAttributes.getInteger(R.styleable.BottomNavigationView_labelVisibilityMode, -1));
        setItemHorizontalTranslationEnabled(obtainTintedStyledAttributes.getBoolean(R.styleable.BottomNavigationView_itemHorizontalTranslationEnabled, true));
        int resourceId = obtainTintedStyledAttributes.getResourceId(R.styleable.BottomNavigationView_itemBackground, 0);
        if (resourceId != 0) {
            this.menuView.setItemBackgroundRes(resourceId);
        } else {
            setItemRippleColor(MaterialResources.getColorStateList(context2, obtainTintedStyledAttributes, R.styleable.BottomNavigationView_itemRippleColor));
        }
        if (obtainTintedStyledAttributes.hasValue(R.styleable.BottomNavigationView_menu)) {
            inflateMenu(obtainTintedStyledAttributes.getResourceId(R.styleable.BottomNavigationView_menu, 0));
        }
        obtainTintedStyledAttributes.recycle();
        addView(this.menuView, layoutParams);
        if (Build.VERSION.SDK_INT < 21) {
            addCompatibilityTopDivider(context2);
        }
        this.menu.setCallback(new MenuBuilder.Callback(this) { // from class: com.google.android.material.bottomnavigation.BottomNavigationView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BottomNavigationView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
            public boolean onMenuItemSelected(MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, menuBuilder, menuItem)) == null) {
                    if (this.this$0.reselectedListener == null || menuItem.getItemId() != this.this$0.getSelectedItemId()) {
                        return (this.this$0.selectedListener == null || this.this$0.selectedListener.onNavigationItemSelected(menuItem)) ? false : true;
                    }
                    this.this$0.reselectedListener.onNavigationItemReselected(menuItem);
                    return true;
                }
                return invokeLL.booleanValue;
            }

            @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
            public void onMenuModeChange(MenuBuilder menuBuilder) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, menuBuilder) == null) {
                }
            }
        });
        applyWindowInsets();
    }
}
