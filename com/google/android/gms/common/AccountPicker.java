package com.google.android.gms.common;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class AccountPicker {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class AccountChooserOptions {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public Account zza;
        public boolean zzb;
        @Nullable
        public ArrayList<Account> zzc;
        @Nullable
        public ArrayList<String> zzd;
        public boolean zze;
        @Nullable
        public String zzf;
        @Nullable
        public Bundle zzg;
        public boolean zzh;
        public int zzi;
        @Nullable
        public String zzj;
        public boolean zzk;
        @Nullable
        public zza zzl;
        @Nullable
        public String zzm;
        public boolean zzn;
        public boolean zzo;

        /* loaded from: classes7.dex */
        public static class Builder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            @Nullable
            public Account zza;
            @Nullable
            public ArrayList<Account> zzb;
            @Nullable
            public ArrayList<String> zzc;
            public boolean zzd;
            @Nullable
            public String zze;
            @Nullable
            public Bundle zzf;

            public Builder() {
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
                this.zzd = false;
            }

            @NonNull
            public AccountChooserOptions build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    Preconditions.checkArgument(true, "We only support hostedDomain filter for account chip styled account picker");
                    Preconditions.checkArgument(true, "Consent is only valid for account chip styled account picker");
                    AccountChooserOptions accountChooserOptions = new AccountChooserOptions();
                    accountChooserOptions.zzd = this.zzc;
                    accountChooserOptions.zzc = this.zzb;
                    accountChooserOptions.zze = this.zzd;
                    accountChooserOptions.zzl = null;
                    accountChooserOptions.zzj = null;
                    accountChooserOptions.zzg = this.zzf;
                    accountChooserOptions.zza = this.zza;
                    accountChooserOptions.zzb = false;
                    accountChooserOptions.zzh = false;
                    accountChooserOptions.zzm = null;
                    accountChooserOptions.zzi = 0;
                    accountChooserOptions.zzf = this.zze;
                    accountChooserOptions.zzk = false;
                    accountChooserOptions.zzn = false;
                    accountChooserOptions.zzo = false;
                    return accountChooserOptions;
                }
                return (AccountChooserOptions) invokeV.objValue;
            }

            @NonNull
            public Builder setAllowableAccounts(@Nullable List<Account> list) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
                    this.zzb = list == null ? null : new ArrayList<>(list);
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            @NonNull
            public Builder setAllowableAccountsTypes(@Nullable List<String> list) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
                    this.zzc = list == null ? null : new ArrayList<>(list);
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            @NonNull
            public Builder setAlwaysShowAccountPicker(boolean z) {
                InterceptResult invokeZ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                    this.zzd = z;
                    return this;
                }
                return (Builder) invokeZ.objValue;
            }

            @NonNull
            public Builder setOptionsForAddingAccount(@Nullable Bundle bundle) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bundle)) == null) {
                    this.zzf = bundle;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            @NonNull
            public Builder setSelectedAccount(@Nullable Account account) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, account)) == null) {
                    this.zza = account;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            @NonNull
            public Builder setTitleOverrideText(@Nullable String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                    this.zze = str;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }
        }

        public AccountChooserOptions() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public AccountPicker() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @NonNull
    @Deprecated
    public static Intent newChooseAccountIntent(@Nullable Account account, @Nullable ArrayList<Account> arrayList, @Nullable String[] strArr, boolean z, @Nullable String str, @Nullable String str2, @Nullable String[] strArr2, @Nullable Bundle bundle) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{account, arrayList, strArr, Boolean.valueOf(z), str, str2, strArr2, bundle})) == null) {
            Intent intent = new Intent();
            Preconditions.checkArgument(true, "We only support hostedDomain filter for account chip styled account picker");
            intent.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
            intent.setPackage("com.google.android.gms");
            intent.putExtra("allowableAccounts", arrayList);
            intent.putExtra("allowableAccountTypes", strArr);
            intent.putExtra("addAccountOptions", bundle);
            intent.putExtra("selectedAccount", account);
            intent.putExtra("alwaysPromptForAccount", z);
            intent.putExtra("descriptionTextOverride", str);
            intent.putExtra("authTokenType", str2);
            intent.putExtra("addAccountRequiredFeatures", strArr2);
            intent.putExtra("setGmsCoreAccount", false);
            intent.putExtra("overrideTheme", 0);
            intent.putExtra("overrideCustomTheme", 0);
            intent.putExtra("hostedDomainFilter", (String) null);
            return intent;
        }
        return (Intent) invokeCommon.objValue;
    }

    @NonNull
    public static Intent newChooseAccountIntent(@NonNull AccountChooserOptions accountChooserOptions) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, accountChooserOptions)) == null) {
            Intent intent = new Intent();
            boolean unused = accountChooserOptions.zzk;
            String unused2 = accountChooserOptions.zzj;
            Preconditions.checkArgument(true, "We only support hostedDomain filter for account chip styled account picker");
            zza unused3 = accountChooserOptions.zzl;
            Preconditions.checkArgument(true, "Consent is only valid for account chip styled account picker");
            boolean unused4 = accountChooserOptions.zzb;
            Preconditions.checkArgument(true, "Making the selected account non-clickable is only supported for the theme THEME_DAY_NIGHT_GOOGLE_MATERIAL2");
            boolean unused5 = accountChooserOptions.zzk;
            intent.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
            intent.setPackage("com.google.android.gms");
            intent.putExtra("allowableAccounts", accountChooserOptions.zzc);
            if (accountChooserOptions.zzd != null) {
                intent.putExtra("allowableAccountTypes", (String[]) accountChooserOptions.zzd.toArray(new String[0]));
            }
            intent.putExtra("addAccountOptions", accountChooserOptions.zzg);
            intent.putExtra("selectedAccount", accountChooserOptions.zza);
            boolean unused6 = accountChooserOptions.zzb;
            intent.putExtra("selectedAccountIsNotClickable", false);
            intent.putExtra("alwaysPromptForAccount", accountChooserOptions.zze);
            intent.putExtra("descriptionTextOverride", accountChooserOptions.zzf);
            boolean unused7 = accountChooserOptions.zzh;
            intent.putExtra("setGmsCoreAccount", false);
            String unused8 = accountChooserOptions.zzm;
            intent.putExtra("realClientPackage", (String) null);
            int unused9 = accountChooserOptions.zzi;
            intent.putExtra("overrideTheme", 0);
            boolean unused10 = accountChooserOptions.zzk;
            intent.putExtra("overrideCustomTheme", 0);
            String unused11 = accountChooserOptions.zzj;
            intent.putExtra("hostedDomainFilter", (String) null);
            Bundle bundle = new Bundle();
            boolean unused12 = accountChooserOptions.zzk;
            zza unused13 = accountChooserOptions.zzl;
            boolean unused14 = accountChooserOptions.zzn;
            boolean unused15 = accountChooserOptions.zzo;
            if (!bundle.isEmpty()) {
                intent.putExtra("first_party_options_bundle", bundle);
            }
            return intent;
        }
        return (Intent) invokeL.objValue;
    }
}
