package com.navartia.adda.ui;

/**
 * This interface must be implemented by activities that contain this fragment to allow
 * an interaction in this fragment to be communicated to the activity and potentially
 * other fragments contained in that activity.
 */
public interface FragmentInteractionListener {
    public void sendMessage(String message);
    public void sendMessage(String message, Object data);
}
