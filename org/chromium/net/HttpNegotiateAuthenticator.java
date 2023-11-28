package org.chromium.net;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import androidx.annotation.VisibleForTesting;
import com.kuaishou.weapon.p0.g;
import java.io.IOException;
import org.chromium.base.ApplicationStatus;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.base.ThreadUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
@JNINamespace("net::android")
/* loaded from: classes2.dex */
public class HttpNegotiateAuthenticator {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String TAG = "net_auth";
    public final String mAccountType;
    public Bundle mSpnegoContext;

    /* loaded from: classes2.dex */
    public interface Natives {
        void setResult(long j, HttpNegotiateAuthenticator httpNegotiateAuthenticator, int i, String str);
    }

    /* loaded from: classes2.dex */
    public static class RequestData {
        public Account account;
        public AccountManager accountManager;
        public String authTokenType;
        public long nativeResultObject;
        public Bundle options;
    }

    @VisibleForTesting
    /* loaded from: classes2.dex */
    public class GetAccountsCallback implements AccountManagerCallback<Account[]> {
        public final RequestData mRequestData;

        public GetAccountsCallback(RequestData requestData) {
            this.mRequestData = requestData;
        }

        @Override // android.accounts.AccountManagerCallback
        public void run(AccountManagerFuture<Account[]> accountManagerFuture) {
            try {
                Account[] result = accountManagerFuture.getResult();
                if (result.length == 0) {
                    Log.w(HttpNegotiateAuthenticator.TAG, "ERR_MISSING_AUTH_CREDENTIALS: No account provided for the kerberos authentication. Please verify the configuration policies and that the CONTACTS runtime permission is granted. ", new Object[0]);
                    HttpNegotiateAuthenticatorJni.get().setResult(this.mRequestData.nativeResultObject, HttpNegotiateAuthenticator.this, NetError.ERR_MISSING_AUTH_CREDENTIALS, null);
                } else if (result.length > 1) {
                    Log.w(HttpNegotiateAuthenticator.TAG, "ERR_MISSING_AUTH_CREDENTIALS: Found %d accounts eligible for the kerberos authentication. Please fix the configuration by providing a single account.", Integer.valueOf(result.length));
                    HttpNegotiateAuthenticatorJni.get().setResult(this.mRequestData.nativeResultObject, HttpNegotiateAuthenticator.this, NetError.ERR_MISSING_AUTH_CREDENTIALS, null);
                } else if (HttpNegotiateAuthenticator.this.lacksPermission(ContextUtils.getApplicationContext(), "android.permission.USE_CREDENTIALS", true)) {
                    Log.e(HttpNegotiateAuthenticator.TAG, "ERR_MISCONFIGURED_AUTH_ENVIRONMENT: USE_CREDENTIALS permission not granted. Aborting authentication.", new Object[0]);
                    HttpNegotiateAuthenticatorJni.get().setResult(this.mRequestData.nativeResultObject, HttpNegotiateAuthenticator.this, NetError.ERR_MISCONFIGURED_AUTH_ENVIRONMENT, null);
                } else {
                    RequestData requestData = this.mRequestData;
                    Account account = result[0];
                    requestData.account = account;
                    requestData.accountManager.getAuthToken(account, requestData.authTokenType, requestData.options, true, (AccountManagerCallback<Bundle>) new GetTokenCallback(requestData), new Handler(ThreadUtils.getUiThreadLooper()));
                }
            } catch (AuthenticatorException | OperationCanceledException | IOException e) {
                Log.w(HttpNegotiateAuthenticator.TAG, "ERR_UNEXPECTED: Error while attempting to retrieve accounts.", e);
                HttpNegotiateAuthenticatorJni.get().setResult(this.mRequestData.nativeResultObject, HttpNegotiateAuthenticator.this, -9, null);
            }
        }
    }

    @VisibleForTesting
    /* loaded from: classes2.dex */
    public class GetTokenCallback implements AccountManagerCallback<Bundle> {
        public final RequestData mRequestData;

        public GetTokenCallback(RequestData requestData) {
            this.mRequestData = requestData;
        }

        @Override // android.accounts.AccountManagerCallback
        public void run(AccountManagerFuture<Bundle> accountManagerFuture) {
            try {
                Bundle result = accountManagerFuture.getResult();
                if (!result.containsKey("intent")) {
                    HttpNegotiateAuthenticator.this.processResult(result, this.mRequestData);
                    return;
                }
                final Context applicationContext = ContextUtils.getApplicationContext();
                applicationContext.registerReceiver(new BroadcastReceiver() { // from class: org.chromium.net.HttpNegotiateAuthenticator.GetTokenCallback.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        applicationContext.unregisterReceiver(this);
                        AccountManager accountManager = GetTokenCallback.this.mRequestData.accountManager;
                        Account account = GetTokenCallback.this.mRequestData.account;
                        String str = GetTokenCallback.this.mRequestData.authTokenType;
                        Bundle bundle = GetTokenCallback.this.mRequestData.options;
                        GetTokenCallback getTokenCallback = GetTokenCallback.this;
                        accountManager.getAuthToken(account, str, bundle, true, (AccountManagerCallback<Bundle>) new GetTokenCallback(getTokenCallback.mRequestData), (Handler) null);
                    }
                }, new IntentFilter("android.accounts.LOGIN_ACCOUNTS_CHANGED"));
            } catch (AuthenticatorException | OperationCanceledException | IOException e) {
                Log.w(HttpNegotiateAuthenticator.TAG, "ERR_UNEXPECTED: Error while attempting to obtain a token.", e);
                HttpNegotiateAuthenticatorJni.get().setResult(this.mRequestData.nativeResultObject, HttpNegotiateAuthenticator.this, -9, null);
            }
        }
    }

    public HttpNegotiateAuthenticator(String str) {
        this.mAccountType = str;
    }

    @VisibleForTesting
    @CalledByNative
    public static HttpNegotiateAuthenticator create(String str) {
        return new HttpNegotiateAuthenticator(str);
    }

    @VisibleForTesting
    public boolean lacksPermission(Context context, String str, boolean z) {
        if ((z && Build.VERSION.SDK_INT >= 23) || context.checkPermission(str, Process.myPid(), Process.myUid()) == 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processResult(Bundle bundle, RequestData requestData) {
        int i;
        this.mSpnegoContext = bundle.getBundle(HttpNegotiateConstants.KEY_SPNEGO_CONTEXT);
        switch (bundle.getInt(HttpNegotiateConstants.KEY_SPNEGO_RESULT, 1)) {
            case 0:
                i = 0;
                break;
            case 1:
            default:
                i = -9;
                break;
            case 2:
                i = -3;
                break;
            case 3:
                i = NetError.ERR_UNEXPECTED_SECURITY_LIBRARY_STATUS;
                break;
            case 4:
                i = NetError.ERR_INVALID_RESPONSE;
                break;
            case 5:
                i = NetError.ERR_INVALID_AUTH_CREDENTIALS;
                break;
            case 6:
                i = NetError.ERR_UNSUPPORTED_AUTH_SCHEME;
                break;
            case 7:
                i = NetError.ERR_MISSING_AUTH_CREDENTIALS;
                break;
            case 8:
                i = NetError.ERR_UNDOCUMENTED_SECURITY_LIBRARY_STATUS;
                break;
            case 9:
                i = NetError.ERR_MALFORMED_IDENTITY;
                break;
        }
        HttpNegotiateAuthenticatorJni.get().setResult(requestData.nativeResultObject, this, i, bundle.getString("authtoken"));
    }

    private void requestTokenWithActivity(Context context, Activity activity, RequestData requestData, String[] strArr) {
        boolean z;
        String str;
        if (Build.VERSION.SDK_INT < 23) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            str = "android.permission.MANAGE_ACCOUNTS";
        } else {
            str = g.f;
        }
        if (lacksPermission(context, str, z)) {
            Log.e(TAG, "ERR_MISCONFIGURED_AUTH_ENVIRONMENT: %s permission not granted. Aborting authentication", str);
            HttpNegotiateAuthenticatorJni.get().setResult(requestData.nativeResultObject, this, NetError.ERR_MISCONFIGURED_AUTH_ENVIRONMENT, null);
            return;
        }
        requestData.accountManager.getAuthTokenByFeatures(this.mAccountType, requestData.authTokenType, strArr, activity, null, requestData.options, new GetTokenCallback(requestData), new Handler(ThreadUtils.getUiThreadLooper()));
    }

    @VisibleForTesting
    @CalledByNative
    public void getNextAuthToken(long j, String str, String str2, boolean z) {
        Context applicationContext = ContextUtils.getApplicationContext();
        RequestData requestData = new RequestData();
        requestData.authTokenType = HttpNegotiateConstants.SPNEGO_TOKEN_TYPE_BASE + str;
        requestData.accountManager = AccountManager.get(applicationContext);
        requestData.nativeResultObject = j;
        String[] strArr = {HttpNegotiateConstants.SPNEGO_FEATURE};
        Bundle bundle = new Bundle();
        requestData.options = bundle;
        if (str2 != null) {
            bundle.putString(HttpNegotiateConstants.KEY_INCOMING_AUTH_TOKEN, str2);
        }
        Bundle bundle2 = this.mSpnegoContext;
        if (bundle2 != null) {
            requestData.options.putBundle(HttpNegotiateConstants.KEY_SPNEGO_CONTEXT, bundle2);
        }
        requestData.options.putBoolean(HttpNegotiateConstants.KEY_CAN_DELEGATE, z);
        Activity lastTrackedFocusedActivity = ApplicationStatus.getLastTrackedFocusedActivity();
        if (lastTrackedFocusedActivity == null) {
            requestTokenWithoutActivity(applicationContext, requestData, strArr);
        } else {
            requestTokenWithActivity(applicationContext, lastTrackedFocusedActivity, requestData, strArr);
        }
    }

    private void requestTokenWithoutActivity(Context context, RequestData requestData, String[] strArr) {
        if (lacksPermission(context, g.f, true)) {
            Log.e(TAG, "ERR_MISCONFIGURED_AUTH_ENVIRONMENT: GET_ACCOUNTS permission not granted. Aborting authentication.", new Object[0]);
            HttpNegotiateAuthenticatorJni.get().setResult(requestData.nativeResultObject, this, NetError.ERR_MISCONFIGURED_AUTH_ENVIRONMENT, null);
            return;
        }
        requestData.accountManager.getAccountsByTypeAndFeatures(this.mAccountType, strArr, new GetAccountsCallback(requestData), new Handler(ThreadUtils.getUiThreadLooper()));
    }
}
