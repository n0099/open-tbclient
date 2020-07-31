package com.googlecode.mp4parser.util;

import com.baidu.android.common.others.IStringUtil;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.Container;
import com.googlecode.mp4parser.AbstractContainerBox;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes20.dex */
public class Path {
    static final /* synthetic */ boolean $assertionsDisabled;
    static Pattern component;

    static {
        $assertionsDisabled = !Path.class.desiredAssertionStatus();
        component = Pattern.compile("(....|\\.\\.)(\\[(.*)\\])?");
    }

    private Path() {
    }

    public static String createPath(Box box) {
        return createPath(box, "");
    }

    private static String createPath(Box box, String str) {
        Container parent = box.getParent();
        int i = 0;
        for (Box box2 : parent.getBoxes()) {
            if (box2.getType().equals(box.getType())) {
                if (box2 == box) {
                    break;
                }
                i++;
            }
        }
        String str2 = String.valueOf(String.format("/%s[%d]", box.getType(), Integer.valueOf(i))) + str;
        return parent instanceof Box ? createPath((Box) parent, str2) : str2;
    }

    public static Box getPath(Box box, String str) {
        List<Box> paths = getPaths(box, str, true);
        if (paths.isEmpty()) {
            return null;
        }
        return paths.get(0);
    }

    public static Box getPath(Container container, String str) {
        List<Box> paths = getPaths(container, str, true);
        if (paths.isEmpty()) {
            return null;
        }
        return paths.get(0);
    }

    public static Box getPath(AbstractContainerBox abstractContainerBox, String str) {
        List<Box> paths = getPaths(abstractContainerBox, str, true);
        if (paths.isEmpty()) {
            return null;
        }
        return paths.get(0);
    }

    public static List<Box> getPaths(AbstractContainerBox abstractContainerBox, String str) {
        return getPaths(abstractContainerBox, str, false);
    }

    public static List<Box> getPaths(Box box, String str) {
        return getPaths(box, str, false);
    }

    public static List<Box> getPaths(Container container, String str) {
        return getPaths(container, str, false);
    }

    private static List<Box> getPaths(AbstractContainerBox abstractContainerBox, String str, boolean z) {
        return getPaths((Object) abstractContainerBox, str, z);
    }

    private static List<Box> getPaths(Container container, String str, boolean z) {
        return getPaths((Object) container, str, z);
    }

    private static List<Box> getPaths(Box box, String str, boolean z) {
        return getPaths((Object) box, str, z);
    }

    private static List<Box> getPaths(Object obj, String str, boolean z) {
        Container container;
        String str2;
        int i;
        int i2 = 0;
        if (str.startsWith("/")) {
            str = str.substring(1);
            container = obj;
            while (container instanceof Box) {
                container = ((Box) container).getParent();
            }
        } else {
            container = obj;
        }
        if (str.length() == 0) {
            if (container instanceof Box) {
                return Collections.singletonList((Box) container);
            }
            throw new RuntimeException("Result of path expression seems to be the root container. This is not allowed!");
        }
        if (str.contains("/")) {
            str2 = str.substring(str.indexOf(47) + 1);
            str = str.substring(0, str.indexOf(47));
        } else {
            str2 = "";
        }
        Matcher matcher = component.matcher(str);
        if (matcher.matches()) {
            String group = matcher.group(1);
            if (IStringUtil.TOP_PATH.equals(group)) {
                if (container instanceof Box) {
                    return getPaths(((Box) container).getParent(), str2, z);
                }
                return Collections.emptyList();
            } else if (container instanceof Container) {
                int parseInt = matcher.group(2) != null ? Integer.parseInt(matcher.group(3)) : -1;
                LinkedList linkedList = new LinkedList();
                for (Box box : ((Container) container).getBoxes()) {
                    if (box.getType().matches(group)) {
                        if (parseInt == -1 || parseInt == i2) {
                            linkedList.addAll(getPaths(box, str2, z));
                        }
                        i = i2 + 1;
                    } else {
                        i = i2;
                    }
                    if ((z || parseInt >= 0) && !linkedList.isEmpty()) {
                        return linkedList;
                    }
                    i2 = i;
                }
                return linkedList;
            } else {
                return Collections.emptyList();
            }
        }
        throw new RuntimeException(String.valueOf(str) + " is invalid path.");
    }

    public static boolean isContained(Box box, String str) {
        if ($assertionsDisabled || str.startsWith("/")) {
            return getPaths(box, str).contains(box);
        }
        throw new AssertionError("Absolute path required");
    }
}
