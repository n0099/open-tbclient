package com.kwai.video.hodor.util;

import android.os.Build;
import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public final class Timber {
    public static final Tree[] TREE_ARRAY_EMPTY = new Tree[0];
    public static final List<Tree> FOREST = new ArrayList();
    public static volatile Tree[] forestAsArray = TREE_ARRAY_EMPTY;
    public static final Tree TREE_OF_SOULS = new Tree() { // from class: com.kwai.video.hodor.util.Timber.1
        @Override // com.kwai.video.hodor.util.Timber.Tree
        public void d(String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.d(str, objArr);
            }
        }

        @Override // com.kwai.video.hodor.util.Timber.Tree
        public void d(Throwable th) {
            for (Tree tree : Timber.forestAsArray) {
                tree.d(th);
            }
        }

        @Override // com.kwai.video.hodor.util.Timber.Tree
        public void d(Throwable th, String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.d(th, str, objArr);
            }
        }

        @Override // com.kwai.video.hodor.util.Timber.Tree
        public void e(String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.e(str, objArr);
            }
        }

        @Override // com.kwai.video.hodor.util.Timber.Tree
        public void e(Throwable th) {
            for (Tree tree : Timber.forestAsArray) {
                tree.e(th);
            }
        }

        @Override // com.kwai.video.hodor.util.Timber.Tree
        public void e(Throwable th, String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.e(th, str, objArr);
            }
        }

        @Override // com.kwai.video.hodor.util.Timber.Tree
        public void i(String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.i(str, objArr);
            }
        }

        @Override // com.kwai.video.hodor.util.Timber.Tree
        public void i(Throwable th) {
            for (Tree tree : Timber.forestAsArray) {
                tree.i(th);
            }
        }

        @Override // com.kwai.video.hodor.util.Timber.Tree
        public void i(Throwable th, String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.i(th, str, objArr);
            }
        }

        @Override // com.kwai.video.hodor.util.Timber.Tree
        public void log(int i2, String str, String str2, Throwable th) {
            throw new AssertionError("Missing override for log method.");
        }

        @Override // com.kwai.video.hodor.util.Timber.Tree
        public void log(int i2, String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.log(i2, str, objArr);
            }
        }

        @Override // com.kwai.video.hodor.util.Timber.Tree
        public void log(int i2, Throwable th) {
            for (Tree tree : Timber.forestAsArray) {
                tree.log(i2, th);
            }
        }

        @Override // com.kwai.video.hodor.util.Timber.Tree
        public void log(int i2, Throwable th, String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.log(i2, th, str, objArr);
            }
        }

        @Override // com.kwai.video.hodor.util.Timber.Tree
        public void v(String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.v(str, objArr);
            }
        }

        @Override // com.kwai.video.hodor.util.Timber.Tree
        public void v(Throwable th) {
            for (Tree tree : Timber.forestAsArray) {
                tree.v(th);
            }
        }

        @Override // com.kwai.video.hodor.util.Timber.Tree
        public void v(Throwable th, String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.v(th, str, objArr);
            }
        }

        @Override // com.kwai.video.hodor.util.Timber.Tree
        public void w(String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.w(str, objArr);
            }
        }

        @Override // com.kwai.video.hodor.util.Timber.Tree
        public void w(Throwable th) {
            for (Tree tree : Timber.forestAsArray) {
                tree.w(th);
            }
        }

        @Override // com.kwai.video.hodor.util.Timber.Tree
        public void w(Throwable th, String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.w(th, str, objArr);
            }
        }

        @Override // com.kwai.video.hodor.util.Timber.Tree
        public void wtf(String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.wtf(str, objArr);
            }
        }

        @Override // com.kwai.video.hodor.util.Timber.Tree
        public void wtf(Throwable th) {
            for (Tree tree : Timber.forestAsArray) {
                tree.wtf(th);
            }
        }

        @Override // com.kwai.video.hodor.util.Timber.Tree
        public void wtf(Throwable th, String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.wtf(th, str, objArr);
            }
        }
    };

    /* loaded from: classes7.dex */
    public static class DebugTree extends Tree {
        public static final Pattern ANONYMOUS_CLASS = Pattern.compile("(\\$\\d+)+$");
        public static final int CALL_STACK_INDEX = 5;
        public static final int MAX_LOG_LENGTH = 4000;
        public static final int MAX_TAG_LENGTH = 23;

        public String createStackElementTag(StackTraceElement stackTraceElement) {
            String className = stackTraceElement.getClassName();
            Matcher matcher = ANONYMOUS_CLASS.matcher(className);
            if (matcher.find()) {
                className = matcher.replaceAll("");
            }
            String substring = className.substring(className.lastIndexOf(46) + 1);
            return (substring.length() <= 23 || Build.VERSION.SDK_INT >= 24) ? substring : substring.substring(0, 23);
        }

        @Override // com.kwai.video.hodor.util.Timber.Tree
        public final String getTag() {
            String tag = super.getTag();
            if (tag != null) {
                return tag;
            }
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace.length > 5) {
                return createStackElementTag(stackTrace[5]);
            }
            throw new IllegalStateException("Synthetic stacktrace didn't have enough elements: are you using proguard?");
        }

        @Override // com.kwai.video.hodor.util.Timber.Tree
        public void log(int i2, String str, String str2, Throwable th) {
            int min;
            if (str2.length() < 4000) {
                if (i2 == 7) {
                    Log.wtf(str, str2);
                    return;
                } else {
                    Log.println(i2, str, str2);
                    return;
                }
            }
            int i3 = 0;
            int length = str2.length();
            while (i3 < length) {
                int indexOf = str2.indexOf(10, i3);
                if (indexOf == -1) {
                    indexOf = length;
                }
                while (true) {
                    min = Math.min(indexOf, i3 + 4000);
                    String substring = str2.substring(i3, min);
                    if (i2 == 7) {
                        Log.wtf(str, substring);
                    } else {
                        Log.println(i2, str, substring);
                    }
                    if (min >= indexOf) {
                        break;
                    }
                    i3 = min;
                }
                i3 = min + 1;
            }
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class Tree {
        public final ThreadLocal<String> explicitTag = new ThreadLocal<>();

        private String getStackTraceString(Throwable th) {
            StringWriter stringWriter = new StringWriter(256);
            PrintWriter printWriter = new PrintWriter((Writer) stringWriter, false);
            th.printStackTrace(printWriter);
            printWriter.flush();
            return stringWriter.toString();
        }

        private void prepareLog(int i2, Throwable th, String str, Object... objArr) {
            String tag = getTag();
            if (isLoggable(tag, i2)) {
                if (str != null && str.length() == 0) {
                    str = null;
                }
                if (str != null) {
                    if (objArr != null && objArr.length > 0) {
                        str = formatMessage(str, objArr);
                    }
                    if (th != null) {
                        str = str + "\n" + getStackTraceString(th);
                    }
                } else if (th == null) {
                    return;
                } else {
                    str = getStackTraceString(th);
                }
                log(i2, tag, str, th);
            }
        }

        public void d(String str, Object... objArr) {
            prepareLog(3, null, str, objArr);
        }

        public void d(Throwable th) {
            prepareLog(3, th, null, new Object[0]);
        }

        public void d(Throwable th, String str, Object... objArr) {
            prepareLog(3, th, str, objArr);
        }

        public void e(String str, Object... objArr) {
            prepareLog(6, null, str, objArr);
        }

        public void e(Throwable th) {
            prepareLog(6, th, null, new Object[0]);
        }

        public void e(Throwable th, String str, Object... objArr) {
            prepareLog(6, th, str, objArr);
        }

        public String formatMessage(String str, Object[] objArr) {
            return String.format(str, objArr);
        }

        public String getTag() {
            String str = this.explicitTag.get();
            if (str != null) {
                this.explicitTag.remove();
            }
            return str;
        }

        public void i(String str, Object... objArr) {
            prepareLog(4, null, str, objArr);
        }

        public void i(Throwable th) {
            prepareLog(4, th, null, new Object[0]);
        }

        public void i(Throwable th, String str, Object... objArr) {
            prepareLog(4, th, str, objArr);
        }

        @Deprecated
        public boolean isLoggable(int i2) {
            return true;
        }

        public boolean isLoggable(String str, int i2) {
            return isLoggable(i2);
        }

        public abstract void log(int i2, String str, String str2, Throwable th);

        public void log(int i2, String str, Object... objArr) {
            prepareLog(i2, null, str, objArr);
        }

        public void log(int i2, Throwable th) {
            prepareLog(i2, th, null, new Object[0]);
        }

        public void log(int i2, Throwable th, String str, Object... objArr) {
            prepareLog(i2, th, str, objArr);
        }

        public void v(String str, Object... objArr) {
            prepareLog(2, null, str, objArr);
        }

        public void v(Throwable th) {
            prepareLog(2, th, null, new Object[0]);
        }

        public void v(Throwable th, String str, Object... objArr) {
            prepareLog(2, th, str, objArr);
        }

        public void w(String str, Object... objArr) {
            prepareLog(5, null, str, objArr);
        }

        public void w(Throwable th) {
            prepareLog(5, th, null, new Object[0]);
        }

        public void w(Throwable th, String str, Object... objArr) {
            prepareLog(5, th, str, objArr);
        }

        public void wtf(String str, Object... objArr) {
            prepareLog(7, null, str, objArr);
        }

        public void wtf(Throwable th) {
            prepareLog(7, th, null, new Object[0]);
        }

        public void wtf(Throwable th, String str, Object... objArr) {
            prepareLog(7, th, str, objArr);
        }
    }

    public Timber() {
        throw new AssertionError("No instances.");
    }

    public static Tree asTree() {
        return TREE_OF_SOULS;
    }

    public static void d(String str, Object... objArr) {
        TREE_OF_SOULS.d(str, objArr);
    }

    public static void d(Throwable th) {
        TREE_OF_SOULS.d(th);
    }

    public static void d(Throwable th, String str, Object... objArr) {
        TREE_OF_SOULS.d(th, str, objArr);
    }

    public static void e(String str, Object... objArr) {
        TREE_OF_SOULS.e(str, objArr);
    }

    public static void e(Throwable th) {
        TREE_OF_SOULS.e(th);
    }

    public static void e(Throwable th, String str, Object... objArr) {
        TREE_OF_SOULS.e(th, str, objArr);
    }

    public static List<Tree> forest() {
        List<Tree> unmodifiableList;
        synchronized (FOREST) {
            unmodifiableList = Collections.unmodifiableList(new ArrayList(FOREST));
        }
        return unmodifiableList;
    }

    public static void i(String str, Object... objArr) {
        TREE_OF_SOULS.i(str, objArr);
    }

    public static void i(Throwable th) {
        TREE_OF_SOULS.i(th);
    }

    public static void i(Throwable th, String str, Object... objArr) {
        TREE_OF_SOULS.i(th, str, objArr);
    }

    public static void log(int i2, String str, Object... objArr) {
        TREE_OF_SOULS.log(i2, str, objArr);
    }

    public static void log(int i2, Throwable th) {
        TREE_OF_SOULS.log(i2, th);
    }

    public static void log(int i2, Throwable th, String str, Object... objArr) {
        TREE_OF_SOULS.log(i2, th, str, objArr);
    }

    public static void plant(Tree tree) {
        if (tree == null) {
            throw new NullPointerException("tree == null");
        }
        if (tree == TREE_OF_SOULS) {
            throw new IllegalArgumentException("Cannot plant Timber into itself.");
        }
        synchronized (FOREST) {
            FOREST.add(tree);
            forestAsArray = (Tree[]) FOREST.toArray(new Tree[FOREST.size()]);
        }
    }

    public static void plant(Tree... treeArr) {
        if (treeArr == null) {
            throw new NullPointerException("trees == null");
        }
        for (Tree tree : treeArr) {
            if (tree == null) {
                throw new NullPointerException("trees contains null");
            }
            if (tree == TREE_OF_SOULS) {
                throw new IllegalArgumentException("Cannot plant Timber into itself.");
            }
        }
        synchronized (FOREST) {
            Collections.addAll(FOREST, treeArr);
            forestAsArray = (Tree[]) FOREST.toArray(new Tree[FOREST.size()]);
        }
    }

    public static Tree tag(String str) {
        for (Tree tree : forestAsArray) {
            tree.explicitTag.set(str);
        }
        return TREE_OF_SOULS;
    }

    public static int treeCount() {
        int size;
        synchronized (FOREST) {
            size = FOREST.size();
        }
        return size;
    }

    public static void uproot(Tree tree) {
        synchronized (FOREST) {
            if (!FOREST.remove(tree)) {
                throw new IllegalArgumentException("Cannot uproot tree which is not planted: " + tree);
            }
            forestAsArray = (Tree[]) FOREST.toArray(new Tree[FOREST.size()]);
        }
    }

    public static void uprootAll() {
        synchronized (FOREST) {
            FOREST.clear();
            forestAsArray = TREE_ARRAY_EMPTY;
        }
    }

    public static void v(String str, Object... objArr) {
        TREE_OF_SOULS.v(str, objArr);
    }

    public static void v(Throwable th) {
        TREE_OF_SOULS.v(th);
    }

    public static void v(Throwable th, String str, Object... objArr) {
        TREE_OF_SOULS.v(th, str, objArr);
    }

    public static void w(String str, Object... objArr) {
        TREE_OF_SOULS.w(str, objArr);
    }

    public static void w(Throwable th) {
        TREE_OF_SOULS.w(th);
    }

    public static void w(Throwable th, String str, Object... objArr) {
        TREE_OF_SOULS.w(th, str, objArr);
    }

    public static void wtf(String str, Object... objArr) {
        TREE_OF_SOULS.wtf(str, objArr);
    }

    public static void wtf(Throwable th) {
        TREE_OF_SOULS.wtf(th);
    }

    public static void wtf(Throwable th, String str, Object... objArr) {
        TREE_OF_SOULS.wtf(th, str, objArr);
    }
}
