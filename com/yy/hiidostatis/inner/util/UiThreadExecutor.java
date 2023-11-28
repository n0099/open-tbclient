package com.yy.hiidostatis.inner.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class UiThreadExecutor {
    public static final Handler HANDLER = new Handler(Looper.getMainLooper()) { // from class: com.yy.hiidostatis.inner.util.UiThreadExecutor.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Runnable callback = message.getCallback();
            if (callback != null) {
                callback.run();
                UiThreadExecutor.decrementToken((Token) message.obj);
                return;
            }
            super.handleMessage(message);
        }
    };
    public static final Map<String, Token> TOKENS = new HashMap();

    /* loaded from: classes2.dex */
    public static final class Token {
        public final String id;
        public int runnablesCount;

        public Token(String str) {
            this.runnablesCount = 0;
            this.id = str;
        }
    }

    public static void cancelAll(String str) {
        Token remove;
        synchronized (TOKENS) {
            remove = TOKENS.remove(str);
        }
        if (remove == null) {
            return;
        }
        HANDLER.removeCallbacksAndMessages(remove);
    }

    public static void decrementToken(Token token) {
        String str;
        Token remove;
        synchronized (TOKENS) {
            int i = token.runnablesCount - 1;
            token.runnablesCount = i;
            if (i == 0 && (remove = TOKENS.remove((str = token.id))) != token) {
                TOKENS.put(str, remove);
            }
        }
    }

    public static Token nextToken(String str) {
        Token token;
        synchronized (TOKENS) {
            token = TOKENS.get(str);
            if (token == null) {
                token = new Token(str);
                TOKENS.put(str, token);
            }
            token.runnablesCount++;
        }
        return token;
    }

    public static void runTask(Runnable runnable) {
        runTask(runnable, 0L);
    }

    public static void runTask(Runnable runnable, long j) {
        runTask("", runnable, j);
    }

    public static void runTask(String str, Runnable runnable, long j) {
        if ("".equals(str)) {
            HANDLER.postDelayed(runnable, j);
            return;
        }
        HANDLER.postAtTime(runnable, nextToken(str), SystemClock.uptimeMillis() + j);
    }
}
