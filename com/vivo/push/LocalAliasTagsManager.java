package com.vivo.push;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.vivo.push.cache.ISubscribeAppAliasManager;
import com.vivo.push.cache.ISubscribeAppTagManager;
import com.vivo.push.cache.impl.SubscribeAppAliasManagerImpl;
import com.vivo.push.model.SubscribeAppInfo;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.model.UnvarnishedMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public class LocalAliasTagsManager {
    public static final String DEFAULT_LOCAL_REQUEST_ID = "push_cache_sp";
    public static final String TAG = "LocalAliasTagsManager";
    private static volatile LocalAliasTagsManager mLocalAliasTagsManager;
    private Context mContext;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private ISubscribeAppAliasManager mSubscribeAppAliasManager;
    private ISubscribeAppTagManager mSubscribeAppTagManager;
    public static final ExecutorService WORK_POOL = Executors.newCachedThreadPool();
    private static final Object SLOCK = new Object();

    /* loaded from: classes3.dex */
    public interface LocalMessageCallback {
        boolean onNotificationMessageArrived(Context context, UPSNotificationMessage uPSNotificationMessage);

        void onTransmissionMessage(Context context, UnvarnishedMessage unvarnishedMessage);
    }

    private LocalAliasTagsManager(Context context) {
        this.mContext = context;
        this.mSubscribeAppTagManager = new com.vivo.push.cache.impl.b(context);
        this.mSubscribeAppAliasManager = new SubscribeAppAliasManagerImpl(context);
    }

    public static final LocalAliasTagsManager getInstance(Context context) {
        if (mLocalAliasTagsManager == null) {
            synchronized (SLOCK) {
                if (mLocalAliasTagsManager == null) {
                    mLocalAliasTagsManager = new LocalAliasTagsManager(context.getApplicationContext());
                }
            }
        }
        return mLocalAliasTagsManager;
    }

    public void setSubscribeAppTagManager(ISubscribeAppTagManager iSubscribeAppTagManager) {
        this.mSubscribeAppTagManager = iSubscribeAppTagManager;
    }

    public void setSubscribeAppAliasManager(ISubscribeAppAliasManager iSubscribeAppAliasManager) {
        this.mSubscribeAppAliasManager = iSubscribeAppAliasManager;
    }

    public String getLocalAlias() {
        SubscribeAppInfo subscribeAppInfo = this.mSubscribeAppAliasManager.getSubscribeAppInfo();
        if (subscribeAppInfo != null) {
            return subscribeAppInfo.getName();
        }
        return null;
    }

    public void setLocalAlias(String str) {
        WORK_POOL.execute(new a(this, str));
    }

    public List<String> getLocalTags() {
        return this.mSubscribeAppTagManager.getSubscribeTags();
    }

    public void setLocalTags(ArrayList<String> arrayList) {
        WORK_POOL.execute(new c(this, arrayList));
    }

    public void init() {
        WORK_POOL.execute(new d(this));
    }

    public void delLocalAlias(String str) {
        WORK_POOL.execute(new e(this, str));
    }

    public void delLocalTags(ArrayList<String> arrayList) {
        WORK_POOL.execute(new f(this, arrayList));
    }

    public void onReceiverMsg(UnvarnishedMessage unvarnishedMessage, LocalMessageCallback localMessageCallback) {
        WORK_POOL.execute(new g(this, unvarnishedMessage, localMessageCallback));
    }

    public boolean onReceiverNotification(UPSNotificationMessage uPSNotificationMessage, LocalMessageCallback localMessageCallback) {
        int targetType = uPSNotificationMessage.getTargetType();
        String tragetContent = uPSNotificationMessage.getTragetContent();
        switch (targetType) {
            case 3:
                SubscribeAppInfo subscribeAppInfo = this.mSubscribeAppAliasManager.getSubscribeAppInfo();
                if (subscribeAppInfo == null || subscribeAppInfo.getTargetStatus() != 1 || !subscribeAppInfo.getName().equals(tragetContent)) {
                    m.a().b(DEFAULT_LOCAL_REQUEST_ID, tragetContent);
                    com.vivo.push.util.m.a(TAG, tragetContent + " has ignored ; current Alias is " + subscribeAppInfo);
                    return true;
                }
                break;
            case 4:
                List<String> subscribeTags = this.mSubscribeAppTagManager.getSubscribeTags();
                if (subscribeTags == null || !subscribeTags.contains(tragetContent)) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add(tragetContent);
                    m.a().b(DEFAULT_LOCAL_REQUEST_ID, arrayList);
                    com.vivo.push.util.m.a(TAG, tragetContent + " has ignored ; current tags is " + subscribeTags);
                    return true;
                }
                break;
        }
        return localMessageCallback.onNotificationMessageArrived(this.mContext, uPSNotificationMessage);
    }

    public void onDelAlias(List<String> list, String str) {
        if (DEFAULT_LOCAL_REQUEST_ID.equals(str)) {
            WORK_POOL.execute(new i(this, list));
        }
    }

    public void onDelTags(List<String> list, String str) {
        if (DEFAULT_LOCAL_REQUEST_ID.equals(str)) {
            WORK_POOL.execute(new j(this, list));
        }
    }

    public void onSetAlias(List<String> list, String str) {
        if (DEFAULT_LOCAL_REQUEST_ID.equals(str)) {
            WORK_POOL.execute(new k(this, list));
        }
    }

    public void onSetTags(List<String> list, String str) {
        if (DEFAULT_LOCAL_REQUEST_ID.equals(str)) {
            WORK_POOL.execute(new b(this, list));
        }
    }
}
