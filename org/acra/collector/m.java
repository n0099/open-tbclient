package org.acra.collector;
/* loaded from: classes.dex */
public class m {
    public static String a(Thread thread) {
        StringBuilder sb = new StringBuilder();
        if (thread != null) {
            sb.append("id=").append(thread.getId()).append("\n");
            sb.append("name=").append(thread.getName()).append("\n");
            sb.append("priority=").append(thread.getPriority()).append("\n");
            if (thread.getThreadGroup() != null) {
                sb.append("groupName=").append(thread.getThreadGroup().getName()).append("\n");
            }
        } else {
            sb.append("No broken thread, this might be a silent exception.");
        }
        return sb.toString();
    }
}
